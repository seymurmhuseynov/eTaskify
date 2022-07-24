package com.eTaskify.repos;

import com.eTaskify.entity.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RepoTask extends CrudRepository<Task,Long> {
    List<Task> findAllByStatusOrderByIdDesc(int status);
    Optional<Task> findByIdAndStatus(long id,int status);
}
