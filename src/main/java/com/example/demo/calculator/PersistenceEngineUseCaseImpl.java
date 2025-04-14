package com.example.demo.calculator;

import com.example.demo.repository.CalculationLogRepository;
import com.example.demo.repository.FormulaRepository;
import com.example.demo.repository.IndicatorsDataRepository;
import com.example.demo.repository.entity.CalculationContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@RequiredArgsConstructor
public class PersistenceEngineUseCaseImpl {
	private final CalculationLogRepository calcLogRepo;
	private final IndicatorsDataRepository indicatorsDataRepo;
	private final FormulaRepository formulaRepository;


	public CalculationContext calculateOnDate(LocalDate reportDate){
		reportDate = LocalDate.of(reportDate.getYear(), reportDate.getMonth(), 1);

		var current = indicatorsDataRepo.findByReportDate(reportDate);
		var prevYear = indicatorsDataRepo.findByReportDate(reportDate.minusYears(1));





		return null;
	}

}
