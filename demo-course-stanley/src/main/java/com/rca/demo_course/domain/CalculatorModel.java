package com.rca.demo_course.domain;

/**
 * Domain model representing a calculation result.
 */
public class CalculatorModel {

    private double operandA;
    private double operandB;
    private double result;
    private String operation;

    public CalculatorModel() {
    }

    public CalculatorModel(double operandA, double operandB, double result, String operation) {
        this.operandA = operandA;
        this.operandB = operandB;
        this.result = result;
        this.operation = operation;
    }

    public double getOperandA() {
        return operandA;
    }

    public void setOperandA(double operandA) {
        this.operandA = operandA;
    }

    public double getOperandB() {
        return operandB;
    }

    public void setOperandB(double operandB) {
        this.operandB = operandB;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}

