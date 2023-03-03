package com.butterfield.paycheckapp.controller;

import com.butterfield.paycheckapp.database.dao.PaycheckDAO;
import com.butterfield.paycheckapp.database.entity.Paycheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static java.lang.System.out;

@Controller
public class PaycheckController {

    @Autowired
    private PaycheckDAO paycheckDAO;

    @RequestMapping(value="paycheck/paycheck", method = RequestMethod.GET)
    public ModelAndView emptyPaycheckPage() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("paycheck/paycheck");
        return response;
    }

    @RequestMapping(value="paycheck/list", method = RequestMethod.GET)
    public ModelAndView listPaychecks() throws Exception {
        ModelAndView response = new ModelAndView();

        List<Paycheck> paychecks = paycheckDAO.findAll();
        System.out.print(paychecks.stream().toList());
        response.addObject(paychecks);

        response.setViewName("paycheck/list");
        return response;
    }
}
