package by.pack.service;

import by.pack.dao.HibernateUserDao;
import by.pack.dto.RegUserDto;
import by.pack.entity.User;
import by.pack.mapper.RegUserDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private HibernateUserDao hibernateUserDao;

    public void save(RegUserDto regUserDto){
        User user = RegUserDtoMapper.RegUserToUser(regUserDto);
        hibernateUserDao.save(user);
    }
}
