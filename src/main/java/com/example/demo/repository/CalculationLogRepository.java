package com.example.demo.repository;

import com.example.demo.repository.entity.CalculationLog;
import org.springframework.data.repository.ListCrudRepository;

public interface CalculationLogRepository extends ListCrudRepository<CalculationLog, Long> {
}
