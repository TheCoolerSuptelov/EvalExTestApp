package com.example.demo.repository;

import com.example.demo.repository.entity.IndicatorsData;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface IndicatorsDataRepository extends ListCrudRepository<IndicatorsData, Long> {


	List<IndicatorsData> findByReportDate(LocalDate localDate);
	List<IndicatorsData> findByRegNum(String regNum);

}
