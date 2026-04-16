package com.rca.demo_course.controller;

import com.rca.demo_course.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * REST controller for calculator operations.
 * Provides HTTP endpoints for basic arithmetic and mathematical operations.
 */
@RestController
@RequestMapping("/api/calculator")
@CrossOrigin(origins = "*")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @Autowired
    private CalculatorHistoryService historyService;

    /**
     * Adds two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the sum of a and b
     */
    @GetMapping("/add")
    public ResponseEntity<CalculatorModel> add(
            @RequestParam double a,
            @RequestParam double b) {
        double result = calculatorService.add(a, b);
        return ResponseEntity.ok(processOperation(a, b, result, "addition"));
    }

    @GetMapping("/subtract")
    public ResponseEntity<CalculatorModel> subtract(
            @RequestParam double a,
            @RequestParam double b) {
        double result = calculatorService.subtract(a, b);
        return ResponseEntity.ok(processOperation(a, b, result, "subtraction"));
    }

    @GetMapping("/multiply")
    public ResponseEntity<CalculatorModel> multiply(
            @RequestParam double a,
            @RequestParam double b) {
        double result = calculatorService.multiply(a, b);
        return ResponseEntity.ok(processOperation(a, b, result, "multiplication"));
    }

    @GetMapping("/divide")
    public ResponseEntity<CalculatorModel> divide(
            @RequestParam double a,
            @RequestParam double b) {
        double result = calculatorService.divide(a, b);
        return ResponseEntity.ok(processOperation(a, b, result, "division"));
    }

    @GetMapping("/power")
    public ResponseEntity<CalculatorModel> power(
            @RequestParam double base,
            @RequestParam double exponent) {
        double result = calculatorService.power(base, exponent);
        return ResponseEntity.ok(processOperation(base, exponent, result, "power"));
    }

    @GetMapping("/sqrt")
    public ResponseEntity<CalculatorModel> squareRoot(@RequestParam double number) {
        double result = calculatorService.squareRoot(number);
        return ResponseEntity.ok(processOperation(number, 0, result, "square root"));
    }

    @GetMapping("/abs")
    public ResponseEntity<CalculatorModel> absolute(@RequestParam double number) {
        double result = calculatorService.absolute(number);
        return ResponseEntity.ok(processOperation(number, 0, result, "absolute value"));
    }

    @GetMapping("/percentage")
    public ResponseEntity<CalculatorModel> percentage(
            @RequestParam double number,
            @RequestParam double percentage) {
        double result = calculatorService.percentage(number, percentage);
        return ResponseEntity.ok(processOperation(number, percentage, result, "percentage"));
    }

    @GetMapping("/modulo")
    public ResponseEntity<CalculatorModel> modulo(
            @RequestParam double a,
            @RequestParam double b) {
        double result = calculatorService.modulo(a, b);
        return ResponseEntity.ok(processOperation(a, b, result, "modulo"));
    }

    /**
     * Processes the result, saves to history, and returns a model.
     */
    private CalculatorModel processOperation(double a, double b, double result, String operation) {
        // Save to history
        com.rca.demo_course.domain.CalculatorHistory history = new com.rca.demo_course.domain.CalculatorHistory();
        history.setOperandA(a);
        history.setOperandB(b);
        history.setResult(result);
        history.setOperation(operation);
        history.setTimestamp(java.time.LocalDateTime.now());
        historyService.saveHistory(history);

        return new CalculatorModel(a, b, result, operation);
    }
}
