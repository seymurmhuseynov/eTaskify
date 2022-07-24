package com.eTaskify.repos;

import com.eTaskify.entity.TaskAssign;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RepoTaskAssign extends CrudRepository<TaskAssign,Long> {
    List<TaskAssign> findAllByUser_Id(long idUser);
    Optional<TaskAssign> findAllByUser_idAndTask_IdAndTask_Status(long idUser,long idTask,int status);
}
