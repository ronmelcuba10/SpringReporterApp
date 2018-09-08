package com.ronnyalfonso.nursereports.nursereports.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * By Ron on 9/3/2018
 */
@Controller
public class HomeController {

    private static final String HOME_URL = "/";

    @RequestMapping(HomeController.HOME_URL)
    public String dashboard() {
        return "home";
    }

}
