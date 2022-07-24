package com.eTaskify.repos;

import com.eTaskify.entity.Organization;
import org.springframework.data.repository.CrudRepository;

public interface RepoOrganisation extends CrudRepository<Organization,Long> {
}
