package com.example.demo.calculator;

import com.example.demo.repository.IndicatorsDataRepository;
import com.example.demo.repository.entity.IndicatorsData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
class PersistenceEngineUseCaseImplTest {

	@Autowired
	private PersistenceEngineUseCaseImpl sut;

	@Autowired
	private IndicatorsDataRepository indicatorsDataRepository;

	@Test
	void calculateOnClient() {
		indicatorsDataRepository.saveAll(
						List.of(
										new IndicatorsData().setRegNum("2").setReportForm("101").setIndicator("10").setIndicatorValue(BigDecimal.ONE).setReportDate(LocalDate.of(2022,12,1)),
										new IndicatorsData().setRegNum("2").setReportForm("101").setIndicator("11").setIndicatorValue(BigDecimal.TEN).setReportDate(LocalDate.of(2022,9,1)),
										new IndicatorsData().setRegNum("2").setReportForm("101").setIndicator("12").setIndicatorValue(BigDecimal.TEN).setReportDate(LocalDate.of(2022,6,1)),
										new IndicatorsData().setRegNum("2").setReportForm("135").setIndicator("13").setIndicatorValue(BigDecimal.TEN).setReportDate(LocalDate.of(2022,6,1)),
										new IndicatorsData().setRegNum("2").setReportForm("135").setIndicator("14").setIndicatorValue(BigDecimal.ONE).setReportDate(LocalDate.of(2022,12,1)),
										new IndicatorsData().setRegNum("2").setReportForm("135").setIndicator("15").setIndicatorValue(BigDecimal.TEN).setReportDate(LocalDate.of(2022,9,1)),
										new IndicatorsData().setRegNum("2").setIndicator("10").setIndicatorValue(BigDecimal.TEN).setReportDate(null)
						)
		);


		var res = sut.calculateOnClient("2");

	}
}