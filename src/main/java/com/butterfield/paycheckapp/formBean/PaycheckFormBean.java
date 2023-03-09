package com.butterfield.paycheckapp.formBean;


import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class PaycheckFormBean {
    private Integer id;

    //    @NotEmpty(message = "Cannot be blank")
    private String paycheckName;

    private Float paycheckAmount;

    private LocalDate paycheckDate;

    private String dayName;

    private Integer daysBetweenCheck;
}
