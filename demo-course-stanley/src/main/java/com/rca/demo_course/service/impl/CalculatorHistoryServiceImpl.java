package com.rca.demo_course.service.impl;

import com.rca.demo_course.domain.CalculatorHistory;
import com.rca.demo_course.repository.CalculatorHistoryRepository;
import com.rca.demo_course.service.CalculatorHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of CalculatorHistoryService.
 */
@Service
public class CalculatorHistoryServiceImpl implements CalculatorHistoryService {

    @Autowired
    private CalculatorHistoryRepository historyRepository;

    @Override
    public CalculatorHistory saveHistory(CalculatorHistory history) {
        return historyRepository.save(history);
    }

    @Override
    public List<CalculatorHistory> getAllHistory() {
        return historyRepository.findAll();
    }

    @Override
    public void clearHistory() {
        historyRepository.deleteAll();
    }
}
