package com.ronnyalfonso.nursereports.nursereports.controllers;

import com.ronnyalfonso.nursereports.nursereports.domain.Nurse;
import com.ronnyalfonso.nursereports.nursereports.ServicesImplementations.NurseServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * By Ron on 9/3/2018
 */
@Controller
public class RegistrationController {

    private static final String REGISTER_URL = "/register";
    private static final String REGISTERED_URL = "/registerprocess";
    private static final String REGISTRATION_VIEW = "register";
    private static final String REGISTERED_SUCCESSFUL_VIEW = "welcome";
    private static final String OBJECT_NAME = "nurse";
    private static final String NURSE_NAME_FIELD = "firstName";

    public NurseServiceImpl nurseServiceImpl;

    @RequestMapping(value=REGISTER_URL, method = RequestMethod.GET)
    public ModelAndView register (HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new ModelAndView(REGISTRATION_VIEW);
        mv.addObject(OBJECT_NAME, new Nurse());
        return mv;
    }

    @RequestMapping(value=REGISTERED_URL, method = RequestMethod.POST)
    public ModelAndView addNurse(HttpServletRequest request, HttpServletResponse response, @ModelAttribute(OBJECT_NAME) Nurse nurse){
        nurseServiceImpl.register(nurse);
        return new ModelAndView( REGISTERED_SUCCESSFUL_VIEW, NURSE_NAME_FIELD, nurse.getFirstName());
    }

}
