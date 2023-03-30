package com.butterfield.paycheckapp.formBean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class TransactionFormBean {
    private Integer id;

    private String name;

    private Float amount;

    private LocalDate date;

    private String recurring;

    private String note;
}
