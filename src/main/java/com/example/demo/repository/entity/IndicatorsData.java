package com.example.demo.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table("INDICATORS_DATA")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class IndicatorsData {

    @Id
    private Long id;
    @Column("REPORT_FORM")
    private String reportForm;
    @Column("INDICATOR")
    private String indicator;
    @Column("INDICATOR_VALUE")
    private BigDecimal indicatorValue;
    @Column("REPORT_DATE")
    private LocalDate reportDate;

}
