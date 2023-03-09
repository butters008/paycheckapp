package com.butterfield.paycheckapp.service;

import com.butterfield.paycheckapp.database.entity.Paycheck;
import com.butterfield.paycheckapp.formBean.PaycheckFormBean;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class PaycheckService {
    public Paycheck saveCheck(@Valid PaycheckFormBean form, Paycheck paycheck){
        paycheck.setPaycheckName(form.getPaycheckName());
        paycheck.setPaycheckAmount(form.getPaycheckAmount());
        paycheck.setPaycheckDate(form.getPaycheckDate());
        paycheck.setDayName(form.getDayName());
        paycheck.setDaysBetweenCheck(form.getDaysBetweenCheck());
        return paycheck;
    }
}
