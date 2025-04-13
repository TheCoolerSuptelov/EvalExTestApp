package com.example.demo;

import com.example.demo.repository.CalculationContextRepository;
import com.example.demo.repository.CalculationLogRepository;
import com.example.demo.repository.FormulaRepository;
import com.example.demo.repository.IndicatorsDataRepository;
import com.example.demo.repository.entity.CalculationContext;
import com.example.demo.repository.entity.CalculationLog;
import com.example.demo.repository.entity.Formula;
import com.example.demo.repository.entity.IndicatorsData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PersistenceLayerTest {

	@Autowired
	private CalculationLogRepository calculationLogRepository;
	@Autowired
	private FormulaRepository formulaRepository;
	@Autowired
	private IndicatorsDataRepository indicatorsDataRepository;
	@Autowired
	private CalculationContextRepository calculationContextRepository;


	@Test
	void calculationLogRepository(){
		var resFormula = formulaRepository.save(
						new Formula().setFormula("(a+b)").setOrder(4)
		);

		var resCalcContext = calculationContextRepository.save(new CalculationContext());
		var res = calculationLogRepository.save(
						new CalculationLog()
										.setEvaluationResult(new BigDecimal("10.2231"))
										.setCalculationContext(AggregateReference.to(resCalcContext.getId()))
										.setFormulaId(AggregateReference.to(resFormula.getId())));

		assertNotNull(res.getId());
		assertNotNull(res.getCalculationContext());
		assertNotNull(res.getFormulaId());
	}

	@Test
	void givenCalculationLogRepo() {
		var res = formulaRepository.save(
						new Formula().setFormula("(a+b)").setOrder(4)
		);

		assertNotNull(res.getId());
	}

	@Test
	void givenIndicatorsDataRepository() {
		var res = indicatorsDataRepository.save(new IndicatorsData().setIndicator("10")
						.setReportForm("101")
						.setIndicatorValue(new BigDecimal("10.2")));


		assertNotNull(res.getId());
	}

	@Test
	void givenCalculationContextRepository(){
		var res = calculationContextRepository.save(new CalculationContext());
		assertNotNull(res.getId());
	}

}
