package com.example.demo.calculator;

import com.example.demo.repository.CalculationLogRepository;
import com.example.demo.repository.FormulaRepository;
import com.example.demo.repository.IndicatorsDataRepository;
import com.example.demo.repository.entity.CalculationContext;
import com.example.demo.repository.entity.IndicatorsData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersistenceEngineUseCaseImpl {
	private final CalculationLogRepository calcLogRepo;
	private final IndicatorsDataRepository indicatorsDataRepo;
	private final FormulaRepository formulaRepository;


	public CalculationContext calculateOnClient(String regNum) {


		var current = indicatorsDataRepo.findByRegNum(regNum);


		for (IndicatorsData indicatorData : current) {
			
		}

		return null;
	}

}
