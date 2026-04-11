package com.rca.demo_course.domain;

import java.time.LocalDateTime;

/**
 * Domain model representing a calculation entry in history.
 */
public class CalculatorHistory {

    private Long id;
    private double operandA;
    private double operandB;
    private double result;
    private String operation;
    private LocalDateTime timestamp;

    public CalculatorHistory() {
    }

    public CalculatorHistory(Long id, double operandA, double operandB, double result, String operation, LocalDateTime timestamp) {
        this.id = id;
        this.operandA = operandA;
        this.operandB = operandB;
        this.result = result;
        this.operation = operation;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
