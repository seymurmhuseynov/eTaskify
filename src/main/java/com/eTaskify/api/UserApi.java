package com.eTaskify.api;

import com.eTaskify.models.RequestSignUp;
import com.eTaskify.models.RequestUser;
import com.eTaskify.services.UserServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/eTaskify/user")
@RestController
public class UserApi {

    private UserServices userServices;

    public UserApi(UserServices userServices) {
        this.userServices = userServices;
    }

    @Operation(responses = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "406", description = "Not Acceptable", content = @Content),
            @ApiResponse(responseCode = "208", description = "Already reported", content = @Content),
            @ApiResponse(responseCode = "411", description = "Length Required", content = @Content(schema = @Schema(hidden = true)))})
    @PostMapping(value = "/signUp", produces = "application/json")
    public ResponseEntity<?> insert(@RequestBody @Valid RequestSignUp requestSignUp) {
        userServices.signUp(requestSignUp);
        return ResponseEntity.ok().build();
    }

    @Operation(responses = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(description = "RuntimeException", content = @Content(schema = @Schema(hidden = true)))})
    @GetMapping(value = "/getUsers", produces = "application/json")
    public ResponseEntity<?> getUser(UsernamePasswordAuthenticationToken authentication) {
        return ResponseEntity.ok().body(userServices.getUsers(authentication));
    }

    @Operation(responses = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "406", description = "Not Acceptable", content = @Content),
            @ApiResponse(description = "RuntimeException", content = @Content(schema = @Schema(hidden = true)))})
    @PostMapping(value = "/addUser", produces = "application/json")
    public ResponseEntity<?> addUser(UsernamePasswordAuthenticationToken authentication, @RequestBody @Valid RequestUser requestSignUp) {
        userServices.addUser(authentication, requestSignUp);
        return ResponseEntity.ok().build();
    }

}
