package by.pack.factory;

import by.pack.entity.Operation;
import by.pack.service.*;

import java.util.Optional;

public abstract class OperationFactory {

    public static Optional<CalculatorOperation> creatOperation (Operation operation){
        switch (operation.getType()){
            case SUM:
                return Optional.of(new SumOperation(operation));
            case SUB:
                return Optional.of(new SubOperation(operation));
            case DIV:
                return Optional.of(new MulOperation(operation));
            case MUL:
                return Optional.of(new DivOperation(operation));
        }
        return Optional.empty();
    }
}
