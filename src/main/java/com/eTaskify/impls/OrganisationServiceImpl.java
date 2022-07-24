package com.eTaskify.impls;

import com.eTaskify.entity.Organization;
import com.eTaskify.repos.RepoOrganisation;
import com.eTaskify.services.OrganizationServices;
import org.springframework.stereotype.Component;

@Component
public class OrganisationServiceImpl implements OrganizationServices {

    private final RepoOrganisation repoOrganisation;

    public OrganisationServiceImpl(RepoOrganisation repoOrganisation) {
        this.repoOrganisation = repoOrganisation;
    }

    @Override
    public Organization save(Organization organization) {
       return repoOrganisation.save(organization);
    }
}
