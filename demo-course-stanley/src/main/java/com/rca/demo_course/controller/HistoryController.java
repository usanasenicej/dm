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
     * Retrieves calculation history entries, optionally filtered by operation.
     *
     * @param operation optional operation name to filter by
     * @return a list of history entries
     */
    @GetMapping
    public ResponseEntity<List<CalculatorHistory>> getHistory(
            @RequestParam(required = false) String operation) {
        if (operation != null && !operation.isEmpty()) {
            return ResponseEntity.ok(historyService.getHistoryByOperation(operation));
        }
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
