package com.eTaskify.impls;

import com.eTaskify.entity.Task;
import com.eTaskify.entity.TaskAssign;
import com.eTaskify.entity.User;
import com.eTaskify.enums.EnumTaskStatus;
import com.eTaskify.models.RequestTask;
import com.eTaskify.models.ResponseTask;
import com.eTaskify.repos.RepoTask;
import com.eTaskify.repos.RepoTaskAssign;
import com.eTaskify.repos.RepoUser;
import com.eTaskify.services.TaskServices;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TaskServiceImpl implements TaskServices {

    private final RepoTask repoTask;
    private final RepoUser repoUser;
    private final RepoTaskAssign repoTaskAssign;
    private final MailService mailService;


    public TaskServiceImpl(RepoTask repoTask, RepoUser repoUser, RepoTaskAssign repoTaskAssign, MailService mailService) {
        this.repoTask = repoTask;
        this.repoUser = repoUser;
        this.repoTaskAssign = repoTaskAssign;
        this.mailService = mailService;
    }

    @Override
    public void create(RequestTask request) {
        Task task = new Task();
        repoTask.save(task
                .setName(request.getName())
                .setTitle(request.getTitle())
                .setDescription(request.getDescription())
                .setStatus(EnumTaskStatus.OPEN.getType())
                .setDeadline(request.getDeadline()));

        request.getIdUsers().forEach(idUser -> {
                    Optional<User> user = repoUser.findById(idUser);
                    if (user.isPresent()) {
                        repoTaskAssign.save(
                                new TaskAssign()
                                        .setTask(task)
                                        .setUser(user.get()));
                        mailService.sendMail(user.get().getEmail());
                    }
                }
        );
    }

    @Override
    public List<ResponseTask> getTasks() {
        List<Task> tasks = repoTask.findAllByStatusOrderByIdDesc(EnumTaskStatus.OPEN.getType());
        return tasks.stream()
                .map(task -> new ResponseTask()
                        .setId(task.getId())
                        .setName(task.getName())
                        .setTitle(task.getTitle())
                        .setDeadline(task.getDeadline())
                        .setStatus(task.getStatus()==EnumTaskStatus.OPEN.getType()?EnumTaskStatus.OPEN.name():EnumTaskStatus.CLOSED.name())
                        .setDescription(task.getDescription())).collect(Collectors.toList());
    }

    @Override
    public void assignTask(UsernamePasswordAuthenticationToken authentication, long idTask) {
        User myUser = repoUser.findByEmail(authentication.getName()).orElseThrow(() -> new RuntimeException("User not found"));
        Optional<TaskAssign> taskAssign=repoTaskAssign.findAllByUser_idAndTask_IdAndTask_Status(myUser.getId(),idTask,EnumTaskStatus.OPEN.getType());
        if (taskAssign.isEmpty()) {
            repoTaskAssign.save(new TaskAssign()
                    .setUser(myUser)
                    .setTask(repoTask.findById(idTask).orElse(null)));
        }else {
            throw new RuntimeException("This task is assigned to that person");
        }
    }


    @Override
    public List<ResponseTask> myTasks(UsernamePasswordAuthenticationToken authentication) {
        User myUser = repoUser.findByEmail(authentication.getName()).orElseThrow(() -> new RuntimeException("User not found"));
        List<TaskAssign> taskAssigns = repoTaskAssign.findAllByUser_Id(myUser.getId());
        return taskAssigns.stream()
                .map(taskAssign -> new ResponseTask()
                        .setId(taskAssign.getId())
                        .setName(taskAssign.getTask().getName())
                        .setTitle(taskAssign.getTask().getTitle())
                        .setDeadline(taskAssign.getTask().getDeadline())
                        .setStatus(taskAssign.getTask().getStatus()==EnumTaskStatus.OPEN.getType()?EnumTaskStatus.OPEN.name():EnumTaskStatus.CLOSED.name())
                        .setDescription(taskAssign.getTask().getDescription())).collect(Collectors.toList());
    }

    @Override
    public void closedTask(UsernamePasswordAuthenticationToken authentication, long idTask) {
        User myUser = repoUser.findByEmail(authentication.getName()).orElseThrow(() -> new RuntimeException("User not found"));
        Optional<Task> task = repoTask.findByIdAndStatus(idTask,EnumTaskStatus.OPEN.getType());
        if (task.isPresent()) {
            repoTask.save(task.get()
                    .setClosedForUser(myUser.getId())
                    .setClosedDate(LocalDateTime.now())
                    .setStatus(EnumTaskStatus.CLOSED.getType()));
        }else{
            throw new RuntimeException("Task not Found");
        }
    }
}