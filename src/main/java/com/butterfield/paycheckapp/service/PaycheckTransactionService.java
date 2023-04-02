package com.butterfield.paycheckapp.service;

import com.butterfield.paycheckapp.database.entity.Paycheck;
import com.butterfield.paycheckapp.database.entity.PaycheckTransaction;
import com.butterfield.paycheckapp.database.entity.Transaction;
import org.springframework.stereotype.Service;

@Service
public class PaycheckTransactionService {
    public PaycheckTransaction savePaycheckTransaction(Paycheck paycheck, Transaction transaction){
        //If I do need to update the objects on this paycheckTransaction, then I need to check for the ID
        PaycheckTransaction paycheckTransaction = new PaycheckTransaction();
        paycheckTransaction.setPaycheckId(paycheck);
        paycheckTransaction.setTransactionId(transaction);
        return paycheckTransaction;
    }
}
