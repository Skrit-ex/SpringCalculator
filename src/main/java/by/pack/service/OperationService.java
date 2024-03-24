package by.pack.service;

import by.pack.dao.HibernateOperationDao;
import by.pack.dto.OperationDto;
import by.pack.entity.Operation;
import by.pack.mapper.OperationDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService {

    @Autowired
    private HibernateOperationDao hibernateOperationDao;


    public void save(Operation operation){
        hibernateOperationDao.save(operation);
    }
}
