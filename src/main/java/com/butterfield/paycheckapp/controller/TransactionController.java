package com.butterfield.paycheckapp.controller;

import com.butterfield.paycheckapp.database.dao.PaycheckDAO;
import com.butterfield.paycheckapp.database.dao.PaycheckTransactionDAO;
import com.butterfield.paycheckapp.database.dao.TransactionDAO;
import com.butterfield.paycheckapp.database.entity.Paycheck;
import com.butterfield.paycheckapp.database.entity.PaycheckTransaction;
import com.butterfield.paycheckapp.database.entity.Transaction;
import com.butterfield.paycheckapp.formBean.TransactionFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Slf4j
@Controller
public class TransactionController {
    @Autowired
    private TransactionDAO transactionDAO;

    @Autowired
    private PaycheckDAO paycheckDAO;

    @Autowired
    private PaycheckTransactionDAO paycheckTransactionDAO;

    @RequestMapping(value="paycheck/{aID}/transaction/submit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView submitTransaction(@Valid TransactionFormBean form, @PathVariable("aID") Integer id) throws Exception {
        ModelAndView response = new ModelAndView();

        Transaction transaction = null;
        log.debug("Incoming Form " + form.toString());

        if (transactionDAO.findById(form.getId()) == null) {

            log.debug("Creating a new transaction");

            //Create new transaction and new paycheck_transaction
            transaction = new Transaction();
            transaction.setName(form.getName());
            transaction.setAmount(form.getAmount());
            transaction.setDate(form.getDate());
            transaction.setRecurring(form.getRecurring());
            transaction.setNote(form.getNote());
            Paycheck paycheck = paycheckDAO.findById(id);
            PaycheckTransaction paycheckTransaction = new PaycheckTransaction();
            paycheckTransaction.setPaycheckId(paycheck);
            paycheckTransaction.setTransactionId(transaction);
            transactionDAO.save(transaction);
            log.debug("transaction "+ transaction);
            log.debug("paycheck "+ paycheck);
            log.debug("paycheckTransaction "+ paycheckTransaction);
            paycheckTransactionDAO.save(paycheckTransaction);
        }
        else {

            log.debug("Updating a transaction");

            //Update the transaction
            transaction = transactionDAO.findById(form.getId());
            transaction.setName(form.getName());
            transaction.setAmount(form.getAmount());
            transaction.setDate(form.getDate());
            transaction.setRecurring(form.getRecurring());
            transaction.setNote(form.getNote());
            transactionDAO.save(transaction);
        }



        response.setViewName("redirect:../../../paycheck/" + id);
        return response;
    }
}
