package com.ronnyalfonso.nursereports.nursereports.controllers;

import com.ronnyalfonso.nursereports.nursereports.domain.Nurse;
import com.ronnyalfonso.nursereports.nursereports.domain.Login;
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
public class LoginController {

    private static final String LOGIN_URL = "/login";
    private static final String LOGIN_VIEW = "login";
    private static final String LOGGED_IN_URL = "/loginprocess";
    private static final String WELCOME_VIEW = "welcome";
    private static final String ERROR_MESSAGE = "Username or Password is wrong!!";
    private static final String NURSE_NAME_FIELD = "firstName";
    private static final String MESSAGE_KEY = "message";

    NurseServiceImpl nurseServiceImpl;

    @RequestMapping(value = LOGIN_URL, method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, @ModelAttribute(LOGIN_VIEW) Login login){

        ModelAndView mv = new ModelAndView(LOGIN_VIEW);
        mv.addObject(LOGIN_VIEW, new Login());
        return mv;

    }


    @RequestMapping(value = LOGGED_IN_URL, method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute(LOGIN_VIEW) Login login) {

        ModelAndView mv = null;
        Nurse nurse = nurseServiceImpl.validateNurse(login);
        if (null != nurse) {
            mv = new ModelAndView(WELCOME_VIEW);
            mv.addObject(NURSE_NAME_FIELD, nurse.getFirstName());
        } else {
            mv = new ModelAndView(LOGIN_VIEW);
            mv.addObject(MESSAGE_KEY, ERROR_MESSAGE);
        }
        return mv;
    }


}
