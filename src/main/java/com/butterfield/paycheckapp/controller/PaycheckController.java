package com.butterfield.paycheckapp.controller;

import com.butterfield.paycheckapp.database.dao.PaycheckDAO;
import com.butterfield.paycheckapp.database.entity.Paycheck;
import com.butterfield.paycheckapp.formBean.PaycheckFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

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
        response.addObject("paycheckList", paychecks);

        response.setViewName("paycheckList");
        return response;
    }

    @RequestMapping(value="paycheck/saveCheck", method = RequestMethod.POST)
    public ModelAndView saveCheck(@Valid PaycheckFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();

        //Adding Check
        Paycheck paycheck = new Paycheck();
        paycheck.setPaycheckName(form.getPaycheckName());
        paycheck.setPaycheckAmount(form.getPaycheckAmount());
        paycheck.setPaycheckDate(form.getPaycheckDate());
        paycheck.setDayName(form.getDayName());
        paycheck.setDaysBetweenCheck(form.getDaysBetweenCheck());

        paycheckDAO.save(paycheck);
//        response.addObject(paycheck);
//        response.setViewName("redirect:../index/" + paycheck.getId());
        response.setViewName("redirect:../paycheck/list");
//        indexWithPaycheck();

        return response;
    }
}
