package com.butterfield.paycheckapp.database.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="paychecks")
public class Paycheck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotEmpty(message = "Cannot be blank")
    @Column(name = "paycheck_name")
    private String paycheckName;

    @NotEmpty(message = "Cannot be blank")
    @Column(name = "paycheck_amount")
    private Integer paycheckAmount;

    @Column(name = "paycheck_date")
    private LocalDate paycheckDate;

    @NotEmpty(message = "Cannot be blank")
    @Column(name = "day_name")
    private String dayName;

    @NotEmpty(message = "Cannot be blank")
    @Column(name = "days_between_check")
    private Integer daysBetweenCheck;
}
