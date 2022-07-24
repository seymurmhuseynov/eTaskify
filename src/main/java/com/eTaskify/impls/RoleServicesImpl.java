package com.eTaskify.impls;

import com.eTaskify.entity.Role;
import com.eTaskify.repos.RepoRole;
import com.eTaskify.services.RoleServices;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoleServicesImpl implements RoleServices {

    private final RepoRole repoRole;

    public RoleServicesImpl(RepoRole repoRole) {
        this.repoRole = repoRole;
    }

    @Override
    public Role findRole(String name) {
        Optional<Role> role=repoRole.findByName(name);
        return role.orElseGet(() -> repoRole.save(new Role().setName(name)));
    }
}
