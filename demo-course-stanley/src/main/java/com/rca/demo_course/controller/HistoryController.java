package com.rca.demo_course.controller;

import com.rca.demo_course.domain.CalculatorHistory;
import com.rca.demo_course.service.CalculatorHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for calculator history operations.
 */
@RestController
@RequestMapping("/api/history")
@CrossOrigin(origins = "*")
public class HistoryController {

    @Autowired
    private CalculatorHistoryService historyService;

    /**
     * Retrieves all calculation history entries.
     *
     * @return a list of history entries
     */
    @GetMapping
    public ResponseEntity<List<CalculatorHistory>> getHistory() {
        return ResponseEntity.ok(historyService.getAllHistory());
    }

    /**
     * Clears all calculation history.
     *
     * @return response entity with success message
     */
    @DeleteMapping
    public ResponseEntity<String> clearHistory() {
        historyService.clearHistory();
        return ResponseEntity.ok("History cleared successfully");
    }
}
