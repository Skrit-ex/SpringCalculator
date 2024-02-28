package by.pack.mapper;

import by.pack.dto.OperationDto;
import by.pack.entity.Operation;
import by.pack.entity.OperationType;

public class OperationDtoMapper {

    public static Operation operationDtoToOperation(OperationDto operationDto){
        Operation operation = new Operation();
        operation.setNum1(Double.parseDouble(operationDto.getNum1()));
        operation.setNum2(Double.parseDouble(operationDto.getNum2()));
        operation.setType(OperationType.valueOf(operationDto.getType()));
        return operation;
    }
}
