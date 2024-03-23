package by.pack.service;

import by.pack.dao.HibernateOperationDao;
import by.pack.dto.OperationDto;
import by.pack.entity.Operation;
import by.pack.entity.SessionOperation;
import by.pack.entity.SessionUser;
import by.pack.mapper.OperationDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OperationService {

    @Autowired
    private HibernateOperationDao hibernateOperationDao;


    public void save(OperationDto operationDto){
        Operation operation = OperationDtoMapper.operationDtoToOperation(operationDto);
        hibernateOperationDao.save(operation);
    }
}
