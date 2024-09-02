package net.javaguides.mmsbackend.service;

import net.javaguides.mmsbackend.dto.LoginDto;
import net.javaguides.mmsbackend.dto.UserDto;
import net.javaguides.mmsbackend.response.UserResponse;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserResponse loginUser(LoginDto loginDto);
}
