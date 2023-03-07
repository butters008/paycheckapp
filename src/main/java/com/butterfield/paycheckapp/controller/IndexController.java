package com.butterfield.paycheckapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class IndexController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();
        return response;
    }

    @RequestMapping(value = "/index/{aID}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView indexWithPaycheck(@PathVariable("aID") Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        log.info("Inside Paycheck Method " + id);
        return response;
    }
}
