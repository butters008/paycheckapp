package com.butterfield.paycheckapp.service;

import com.butterfield.paycheckapp.database.entity.Transaction;
import com.butterfield.paycheckapp.formBean.TransactionFormBean;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class TransactionService {
    public Transaction saveTransaction(@Valid TransactionFormBean form, Transaction transaction){
        transaction.setName(form.getName());
        transaction.setAmount(form.getAmount());
        transaction.setDate(form.getDate());
        transaction.setRecurring(form.getRecurring());
        transaction.setNote(form.getNote());
        transaction.setType(form.getType());
        return transaction;
    }

    public float getExpenseTotal(List<Transaction> transactionList){
        float expenseTotal = 0F;
        for(int i = 0; i < transactionList.size(); i++){
            Transaction transaction = transactionList.get(i);
            if(transaction.getType().equals("expense")){
                expenseTotal += transaction.getAmount();
            }
        }
        return expenseTotal;
    }

    public float getIncomeTotal(List<Transaction> transactionList){
        float expenseTotal = 0F;
        for(int i = 0; i < transactionList.size(); i++){
            Transaction transaction = transactionList.get(i);
            if(transaction.getType().equals("income")){
                expenseTotal += transaction.getAmount();
            }
        }
        return expenseTotal;
    }

}
