package net.javaguides.mmsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.mmsbackend.dto.LoginDto;
import net.javaguides.mmsbackend.dto.UserDto;
import net.javaguides.mmsbackend.response.UserResponse;
import net.javaguides.mmsbackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    //Build  Add User REST API
    @PostMapping("/user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping(path = "login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDTO)
    {
        UserResponse userResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(userResponse);
    }
}
