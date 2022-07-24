package com.eTaskify.repos;

import com.eTaskify.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RepoRole extends CrudRepository<Role,Long> {
    Optional<Role> findByName(String name);
}
