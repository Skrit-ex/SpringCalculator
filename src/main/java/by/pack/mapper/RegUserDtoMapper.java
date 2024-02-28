package by.pack.mapper;

import by.pack.dto.RegUserDto;
import by.pack.entity.User;

public class RegUserDtoMapper {

    public static User RegUserToUser (RegUserDto regUserDto){
        User user = new User();
        user.setFirstname(regUserDto.getFirstname());
        user.setLastname(regUserDto.getLastname());
        user.setEmail(regUserDto.getEmail());
        user.setPassword(regUserDto.getPassword());
        user.setUsername(regUserDto.getUsername());
        return user;
    }
}
