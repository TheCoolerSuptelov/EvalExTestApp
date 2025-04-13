package com.example.demo.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("CALCULATION_CONTEXT")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class CalculationContext {

	@Id
	private Long id;
}
