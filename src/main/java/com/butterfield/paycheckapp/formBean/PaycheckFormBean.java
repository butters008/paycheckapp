package com.butterfield.paycheckapp.formBean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class PaycheckFormBean {

    private Integer id;

    @Column(name = "paycheck_name")
    private String paycheckName;

    @Column(name = "paycheck_amount")
    private Integer paycheckAmount;

    @NotEmpty(message = "Cannot be blank")
    private LocalDate paycheckDate;

    @NotEmpty(message = "Cannot be blank")
    private String dayName;

    @NotEmpty(message = "Cannot be blank")
    private Integer daysBetweenCheck;
}
