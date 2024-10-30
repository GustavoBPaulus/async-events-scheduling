package br.com.skilslmanager.asynceventsscheduling.api.users.controllers;

import br.com.skilslmanager.asynceventsscheduling.api.users.dto.UserRequest;
import br.com.skilslmanager.asynceventsscheduling.api.users.dto.UserResponse;
import br.com.skilslmanager.asynceventsscheduling.api.users.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest){
        return userService.create(userRequest);
    }


}
