package com.butterfield.paycheckapp.controller;

import com.butterfield.paycheckapp.database.dao.PaycheckDAO;
import com.butterfield.paycheckapp.database.entity.Paycheck;
import com.butterfield.paycheckapp.formBean.PaycheckFormBean;
import com.butterfield.paycheckapp.service.PaycheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class PaycheckController {

    @Autowired
    private PaycheckDAO paycheckDAO;

    @Autowired
    private PaycheckService paycheckService = new PaycheckService();

    @RequestMapping(value="paycheck/paycheck", method = RequestMethod.GET)
    public ModelAndView emptyPaycheckPage() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("paycheckInfo");
        return response;
    }

    @RequestMapping(value="paycheck/list", method = RequestMethod.GET)
    public ModelAndView listPaychecks() throws Exception {
        ModelAndView response = new ModelAndView();

        List<Paycheck> paychecks = paycheckDAO.findAll();
        System.out.print(paychecks.stream().toList());
        response.addObject("paycheckList", paychecks);

        response.setViewName("paycheck/paycheckList");
        return response;
    }


    @RequestMapping(value="paycheck/saveCheck", method = RequestMethod.POST)
    public ModelAndView saveCheck(@Valid PaycheckFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();

        Paycheck paycheck = null;
        log.debug("Incoming form ID: " );

        if (form.getId() == null) {
            paycheck = new Paycheck();
            paycheck = paycheckService.saveCheck(form, paycheck);
            response.setViewName("redirect:../paycheck/list");
        }
        else{
            paycheck = paycheckDAO.findById(form.getId());
            paycheck = paycheckService.saveCheck(form, paycheck);
            response.setViewName("redirect:../paycheck/"+ paycheck.getId());
        }
        paycheckDAO.save(paycheck);

        return response;
    }

    @RequestMapping(value = "/paycheck/{aID}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView indexWithPaycheck(@PathVariable("aID") Integer id) throws Exception {
        ModelAndView response = new ModelAndView();

        Paycheck paycheck = new Paycheck();

        if (paycheckDAO.findById(id) == null) {
            log.debug("No check!");
        }else{
            paycheck = paycheckDAO.findById(id);
        }

        response.addObject("paycheck", paycheck);
        response.setViewName("paycheck/paycheckInfo");
        return response;
    }
    
}
