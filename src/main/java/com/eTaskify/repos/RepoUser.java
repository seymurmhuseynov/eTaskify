package com.eTaskify.repos;

import com.eTaskify.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RepoUser extends CrudRepository<User,Long> {
    Optional<User> findByEmail(String email);
    List<User> findAll();
    List<User> findAllByOrganization_Id(long idOrganization);
}
