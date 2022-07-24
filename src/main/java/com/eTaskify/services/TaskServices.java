package com.eTaskify.services;

import com.eTaskify.models.RequestTask;
import com.eTaskify.models.ResponseTask;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.List;

public interface TaskServices {
    void create(RequestTask request);
    List<ResponseTask> getTasks();
    void assignTask(UsernamePasswordAuthenticationToken authentication,long idTask);
    List<ResponseTask> myTasks(UsernamePasswordAuthenticationToken authentication);
    void closedTask(UsernamePasswordAuthenticationToken authentication,long idTask);
}
