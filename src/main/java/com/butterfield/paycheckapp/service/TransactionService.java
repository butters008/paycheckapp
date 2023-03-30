package com.butterfield.paycheckapp.service;

import com.butterfield.paycheckapp.database.entity.Transaction;
import com.butterfield.paycheckapp.formBean.TransactionFormBean;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class TransactionService {
    public Transaction saveTransaction(@Valid TransactionFormBean form, Transaction transaction){
        transaction.setName(form.getName());
        return transaction;
    }

}
