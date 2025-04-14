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
import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
	void shouldFindAllByReportDate() {

		indicatorsDataRepository.saveAll(List.of(new IndicatorsData().setIndicator("10")
										.setIndicatorValue(BigDecimal.ONE)
										.setReportDate(LocalDate.of(2022, 12, 1)),
						new IndicatorsData().setIndicator("10")
										.setIndicatorValue(BigDecimal.TEN)
										.setReportDate(LocalDate.of(2022, 11, 1)),
						new IndicatorsData().setIndicator("10").setIndicatorValue(BigDecimal.TEN).setReportDate(null)));

		var res = indicatorsDataRepository.findByReportDate(LocalDate.of(2022, 12, 1));


		assertThat(res, hasSize(1));
	}

	@Test
	void shouldFindByRegNum() {

		indicatorsDataRepository.saveAll(List.of(new IndicatorsData().setRegNum("2")
										.setIndicator("10")
										.setIndicatorValue(BigDecimal.ONE)
										.setReportDate(LocalDate.of(2022, 12, 1)),
						new IndicatorsData().setRegNum("2")
										.setIndicator("10")
										.setIndicatorValue(BigDecimal.TEN)
										.setReportDate(LocalDate.of(2022, 11, 1)),
						new IndicatorsData().setRegNum("2")
										.setIndicator("10")
										.setIndicatorValue(BigDecimal.TEN)
										.setReportDate(null)));

		var res = indicatorsDataRepository.findByRegNum("2");


		assertThat(res, hasSize(3));
	}


	@Test
	void calculationLogRepository() {
		var resFormula = formulaRepository.save(new Formula().setFormula("(a+b)").setOrder(4));

		var resCalcContext = calculationContextRepository.save(new CalculationContext());
		var res = calculationLogRepository.save(new CalculationLog().setEvaluationResult(new BigDecimal("10.2231"))
						.setCalculationContext(AggregateReference.to(resCalcContext.getId()))
						.setFormulaId(AggregateReference.to(resFormula.getId())));

		assertNotNull(res.getId());
		assertNotNull(res.getCalculationContext());
		assertNotNull(res.getFormulaId());
	}

	@Test
	void givenCalculationLogRepo() {
		var res = formulaRepository.save(new Formula().setFormula("(a+b)").setOrder(4).setName("ROI"));

		assertNotNull(res.getId());
		assertEquals("ROI", res.getName());
	}

	@Test
	void givenIndicatorsDataRepository() {
		var res = indicatorsDataRepository.save(new IndicatorsData().setIndicator("10")
						.setReportForm("101")
						.setRegNum("222")
						.setIndicatorValue(new BigDecimal("10.2")));


		assertNotNull(res.getId());
	}

	@Test
	void givenCalculationContextRepository() {
		var res = calculationContextRepository.save(new CalculationContext());
		assertNotNull(res.getId());
	}

}
