package com.example.demo.calculator;

import com.example.demo.repository.CalculationLogRepository;
import com.example.demo.repository.FormulaRepository;
import com.example.demo.repository.IndicatorsDataRepository;
import com.example.demo.repository.entity.CalculationContext;
import com.example.demo.repository.entity.IndicatorsData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersistenceEngineUseCaseImpl {
	private final CalculationLogRepository calcLogRepo;
	private final IndicatorsDataRepository indicatorsDataRepo;
	private final FormulaRepository formulaRepository;
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public CalculationContext calculateOnClient(String regNum) {

		Map<String, Map<String, Map<String, BigDecimal>>>
						contextPeriodFormIndicator_value = buildContext(regNum);


		return null;
	}

	private Map<String, Map<String, Map<String, BigDecimal>>> buildContext(String regNum) {
		var current = indicatorsDataRepo.findByRegNumOrderByReportDateDesc(regNum);

		Map<String, Map<String, Map<String, BigDecimal>>> contextPeriodFormIndicator_value = new HashMap<>();

		LocalDate curDate = LocalDate.MIN;
		int offset = -1;
		for (IndicatorsData indicatorsData : current) {

			if (indicatorsData.getReportDate() == null) {
				continue;
			}

			if (!Objects.equals(indicatorsData.getReportDate(), curDate)) {
				curDate = indicatorsData.getReportDate();
				offset++;
			}
			var reportForm = "_" + indicatorsData.getReportForm();
			//var reportDate = "_" + DATE_FORMATTER.format(indicatorsData.getReportDate());
			var reportDate = "current%s".formatted(offset == 0 ? "" : "-" + offset);
			var indicator = "_" + indicatorsData.getIndicator();


			Map<String, Map<String, BigDecimal>> contextForm =
							contextPeriodFormIndicator_value.computeIfAbsent(reportDate, (key) -> new HashMap<>());


			Map<String, BigDecimal> contextIndicator = contextForm.computeIfAbsent(reportForm,
							(keyReportForm) -> new HashMap<>());

			contextIndicator.put(indicator, indicatorsData.getIndicatorValue());

		}
		return contextPeriodFormIndicator_value;
	}

	private static Map<String, BigDecimal> getPut(Map<String, Map<String, BigDecimal>> periodValue, String keyForm) {
		periodValue = new HashMap<>();
		return periodValue.put(keyForm, new HashMap<>());
	}


	public static <K, V> Map<K, V> computeThis(Map<K, V> thiz,
																						 K key,
																						 BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
		if (thiz == null) {
			thiz = new HashMap<>();
		}
		thiz.compute(key, remappingFunction);
		return thiz;
	}

	private static Map<String, BigDecimal> putIfPresent(BigDecimal indicatorsData,
																											Map<String, BigDecimal> indicators,
																											String indicator) {
		indicators.compute(indicator,
						(keyIndicator, valueIndicator) -> Optional.ofNullable(valueIndicator).orElse(indicatorsData));

		return indicators;
	}


}



