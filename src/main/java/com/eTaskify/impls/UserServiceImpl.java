package com.eTaskify.impls;

import com.eTaskify.entity.Organization;
import com.eTaskify.entity.User;
import com.eTaskify.enums.EnumUser;
import com.eTaskify.models.RequestSignUp;
import com.eTaskify.models.RequestUser;
import com.eTaskify.models.ResponseUsers;
import com.eTaskify.repos.RepoUser;
import com.eTaskify.services.OrganizationServices;
import com.eTaskify.services.UserServices;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserServices, UserDetailsService {

    private final RepoUser repoUser;
    private final OrganizationServices organizationServices;
    private final RoleServicesImpl roleServicesImpl;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(RepoUser repoUser, OrganizationServices organizationServices, RoleServicesImpl roleServicesImpl, PasswordEncoder passwordEncoder) {
        this.repoUser = repoUser;
        this.organizationServices = organizationServices;
        this.roleServicesImpl = roleServicesImpl;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void signUp(RequestSignUp requestSignUp) {
        Organization organization = organizationServices.save(
                new Organization()
                        .setName(requestSignUp.getOrganizationName())
                        .setPhoneNumber(requestSignUp.getPhoneNumber())
                        .setAddress(requestSignUp.getAddress()));

        User user = new User()
                .setName(requestSignUp.getName())
                .setSurname(requestSignUp.getSurname())
                .setEmail(requestSignUp.getEmail())
                .setPassword(passwordEncoder.encode(requestSignUp.getPassword()))
                .setType(EnumUser.ADMIN.getType())
                .setOrganization(organization);

        user.getRoles().add(roleServicesImpl.findRole("ROLE_ADMIN"));
        repoUser.save(user);
    }

    @Override
    public void addUser(UsernamePasswordAuthenticationToken authentication, RequestUser requestUser) {
        repoUser.findByEmail(authentication.getName()).orElseThrow(() -> new RuntimeException("User not found"));
        User user = new User()
                .setName(requestUser.getName())
                .setSurname(requestUser.getSurname())
                .setEmail(requestUser.getEmail())
                .setType(EnumUser.USER.getType())
                .setPassword(passwordEncoder.encode("123456789"));

        user.getRoles().add(roleServicesImpl.findRole("ROLE_USER"));
        repoUser.save(user);
    }

    @Override
    public List<ResponseUsers> getUsers(UsernamePasswordAuthenticationToken authentication) {
        User myUser = repoUser.findByEmail(authentication.getName()).orElseThrow(() -> new RuntimeException("User not found"));
        List<User> users = repoUser.findAllByOrganization_Id(myUser.getOrganization().getId());
         return users.stream()
                .map(user -> new ResponseUsers()
                        .setId(user.getId())
                        .setName(user.getName())
                        .setSurname(user.getSurname())
                        .setEmail(user.getEmail())).collect(Collectors.toList());
    }


    @Override
    public UserDetails loadUserByUsername(String email) {
        Optional<User> user = repoUser.findByEmail(email);
        if (user.isPresent()) {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.get().getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            return new org.springframework.security.core.userdetails.User(user.get().getEmail(), user.get().getPassword(), authorities);
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
