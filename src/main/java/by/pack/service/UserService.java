package by.pack.service;

import by.pack.dao.HibernateUserDao;
import by.pack.dto.LoginUserDto;
import by.pack.dto.RegUserDto;
import by.pack.entity.SessionUser;
import by.pack.entity.User;
import by.pack.mapper.RegUserDtoMapper;
import by.pack.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private HibernateUserDao hibernateUserDao;

    public void save(RegUserDto regUserDto) {
        User user = RegUserDtoMapper.RegUserToUser(regUserDto);
        hibernateUserDao.save(user);
    }

    public Optional<SessionUser> login(LoginUserDto loginUserDto) {
        Optional<User> user = hibernateUserDao.findByEmail(loginUserDto.getEmail());
        if (user.isPresent()) {

            User currentUser = user.get();

            if (currentUser.getPassword().equals(loginUserDto.getPassword())) {
                return Optional.of(UserMapper.userToSessionUser(currentUser));
            }
        }
        return Optional.empty();
    }
}
