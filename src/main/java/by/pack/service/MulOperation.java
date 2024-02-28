package by.pack.service;

import by.pack.entity.Operation;

import java.time.LocalDateTime;

public class MulOperation implements CalculatorOperation{

    private final Operation operation;

    public MulOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void process() {
        operation.setResult(operation.getNum1()*operation.getNum2());
        operation.setTime(LocalDateTime.now());
    }

    @Override
    public Operation getFinalResult() {
        return operation;
    }
}
