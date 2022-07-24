package com.eTaskify.services;

import com.eTaskify.models.RequestSignUp;
import com.eTaskify.models.RequestUser;
import com.eTaskify.models.ResponseUsers;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.List;

public interface UserServices {
    void signUp(RequestSignUp requestSignUp);
    void addUser(UsernamePasswordAuthenticationToken authentication,RequestUser requestUser);
    List<ResponseUsers> getUsers(UsernamePasswordAuthenticationToken authentication);
}