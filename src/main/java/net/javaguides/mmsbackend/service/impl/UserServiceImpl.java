package net.javaguides.mmsbackend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.mmsbackend.dto.LoginDto;
import net.javaguides.mmsbackend.dto.UserDto;
import net.javaguides.mmsbackend.entity.User;
import net.javaguides.mmsbackend.mapper.UserMapper;
import net.javaguides.mmsbackend.repository.UserRepository;
import net.javaguides.mmsbackend.response.UserResponse;
import net.javaguides.mmsbackend.service.UserService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserResponse loginUser(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail());
        if (user != null) {
            if (loginDto.getPassword().equals(user.getPassword())) {
                return new UserResponse("Login Success", true);
            } else {
                return new UserResponse("Password is incorrect", false);
            }
        } else {
            return new UserResponse("Email does not exist", false);
        }
    }
}
