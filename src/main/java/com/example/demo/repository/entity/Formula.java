package com.example.demo.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("FORMULAS")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Formula {
    @Id
    private Long id;
    @Column("FORMULA")
    private String formula;
    @Column("ORDER")
    private Integer order;
    @Column("name")
    private String name;
}
