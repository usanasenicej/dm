package com.rca.demo_course.repository;

import com.rca.demo_course.domain.CalculatorHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for CalculatorHistory entities.
 * Provides standard CRUD operations and custom queries.
 */
@Repository
public interface CalculatorHistoryRepository extends JpaRepository<CalculatorHistory, Long> {
    /**
     * Finds history entries by operation name.
     *
     * @param operation the operation name
     * @return a list of matching entries
     */
    java.util.List<CalculatorHistory> findByOperationIgnoreCase(String operation);
}
