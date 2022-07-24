package com.eTaskify.api;

import com.eTaskify.models.RequestTask;
import com.eTaskify.services.TaskServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/eTaskify/task")
@RestController
public class TaskApi {

    private final TaskServices taskServices;

    public TaskApi(TaskServices taskServices) {
        this.taskServices = taskServices;
    }

    @Operation(responses = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "406", description = "Not Acceptable", content = @Content),
            @ApiResponse(description = "RuntimeException", content = @Content(schema = @Schema(hidden = true)))})
    @PostMapping(value = "/create", produces = "application/json")
    public ResponseEntity<?> create(@RequestBody RequestTask requestTask) {
        taskServices.create(requestTask);
        return ResponseEntity.ok().build();
    }

    @Operation(responses = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(description = "RuntimeException", content = @Content(schema = @Schema(hidden = true)))})
    @GetMapping(value = "/getTasks", produces = "application/json")
    public ResponseEntity<?> getTasks() {
        return ResponseEntity.ok().body(taskServices.getTasks());
    }

    @Operation(responses = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(description = "RuntimeException", content = @Content(schema = @Schema(hidden = true)))})
    @GetMapping(value = "/assign/{idTask}", produces = "application/json")
    public ResponseEntity<?> assignTask(UsernamePasswordAuthenticationToken authentication, @PathVariable long idTask) {
        taskServices.assignTask(authentication, idTask);
        return ResponseEntity.ok().build();
    }

    @Operation(responses = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(description = "RuntimeException", content = @Content(schema = @Schema(hidden = true)))})
    @GetMapping(value = "/myTasks", produces = "application/json")
    public ResponseEntity<?> myTasks(UsernamePasswordAuthenticationToken authentication) {
        return ResponseEntity.ok().body(taskServices.myTasks(authentication));
    }

    @Operation(responses = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(description = "RuntimeException", content = @Content(schema = @Schema(hidden = true)))})
    @GetMapping(value = "/closedTask/{idTask}", produces = "application/json")
    public ResponseEntity<?> closedTask(UsernamePasswordAuthenticationToken authentication, @PathVariable long idTask) {
        taskServices.closedTask(authentication, idTask);
        return ResponseEntity.ok().build();
    }

}
