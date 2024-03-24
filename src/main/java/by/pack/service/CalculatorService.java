package by.pack.service;

import by.pack.dao.HibernateUserDao;
import by.pack.dto.OperationDto;
import by.pack.entity.Operation;
import by.pack.entity.User;
import by.pack.factory.OperationFactory;
import by.pack.mapper.OperationDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CalculatorService {

    @Autowired
    private HibernateUserDao hibernateUserDao;

    public Optional<Operation> calculate (OperationDto operationDto){

        Operation operation = OperationDtoMapper.operationDtoToOperation(operationDto);
        User user = hibernateUserDao.findById(operationDto.getUserId());
        operation.setUser(user);

        Optional<CalculatorOperation>optionalCalculatorOperation = OperationFactory.creatOperation(operation);
        if(optionalCalculatorOperation.isPresent()){

            CalculatorOperation calculatorOperation =optionalCalculatorOperation.get();
            calculatorOperation.process();
            Operation finalResult = calculatorOperation.getFinalResult();
            if(operation.getUser() != null){
                hibernateUserDao.save(user);
                operation.setResult(finalResult.getResult());
            }
            return Optional.of(calculatorOperation.getFinalResult());

        }
        return Optional.empty();
    }
}
