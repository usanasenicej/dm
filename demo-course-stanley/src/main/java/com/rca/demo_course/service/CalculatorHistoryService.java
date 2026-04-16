package com.rca.demo_course.service;

import com.rca.demo_course.domain.CalculatorHistory;
import java.util.List;

/**
 * Service interface for managing calculator history.
 */
public interface CalculatorHistoryService {

    /**
     * Saves a calculation entry to history.
     *
     * @param history the history entry to save
     * @return the saved history entry
     */
    CalculatorHistory saveHistory(CalculatorHistory history);

    /**
     * Retrieves all calculation history entries.
     *
     * @return a list of all history entries
     */
    List<CalculatorHistory> getAllHistory();

    /**
     * Clears all calculation history.
     */
    void clearHistory();
}
