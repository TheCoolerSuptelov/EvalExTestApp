package com.example.demo.repository.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("CALCULATION_LOG")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class CalculationLog {

    @Id
    private Long id;

    @Column("FORMULA_ID")
    private AggregateReference<Formula, Long> formulaId;

    @Column("FORMULA_EVALUATION_RESULT")
    private BigDecimal evaluationResult;
}
