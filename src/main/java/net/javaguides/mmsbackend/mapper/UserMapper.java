package net.javaguides.mmsbackend.mapper;

import net.javaguides.mmsbackend.dto.UserDto;
import net.javaguides.mmsbackend.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user) {
        return new UserDto(
          user.getId(),
          user.getUsername(),
          user.getEmail(),
          user.getPassword()
        );
    }

    public static User mapToUser(UserDto userDto) {
        return new User(
          userDto.getId(),
          userDto.getUserName(),
          userDto.getEmail(),
          userDto.getPassword()
        );
    }
}
