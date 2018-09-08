package com.ronnyalfonso.nursereports.nursereports.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * By Ron on 9/3/2018
 */
@Controller
@RequestMapping(AboutUsController.ABOUT_US_URL)
public class AboutUsController {

    public static final String ABOUT_US_URL = "/aboutus";

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "aboutus.index";
    }
}
