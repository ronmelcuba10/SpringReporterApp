package com.ronnyalfonso.nursereports.nursereports.controllers;

import com.ronnyalfonso.nursereports.nursereports.ServicesImplementations.AgencyServiceImpl;
import com.ronnyalfonso.nursereports.nursereports.ServicesImplementations.NurseServiceImpl;
import com.ronnyalfonso.nursereports.nursereports.ServicesImplementations.PatientServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * By Ron on 9/2/2018
 */
@Controller
public class DashboardController {

    private final NurseServiceImpl nurseServiceImpl;
    private final PatientServiceImpl patientServiceImpl;
    private final AgencyServiceImpl agencyServiceImpl;

    public DashboardController(NurseServiceImpl nurseServiceImpl, PatientServiceImpl patientServiceImpl, AgencyServiceImpl agencyServiceImpl) {
        this.nurseServiceImpl = nurseServiceImpl;
        this.patientServiceImpl = patientServiceImpl;
        this.agencyServiceImpl = agencyServiceImpl;
    }


    @GetMapping("/dashboard")
    public String dashboard(@RequestParam(name="no Ron", required=false, defaultValue="Ron") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("nurses", nurseServiceImpl.findAllNurse());
        model.addAttribute("nurse", nurseServiceImpl.findNurseById(1L));
        model.addAttribute("allpatients", patientServiceImpl.findAllPatient());
        model.addAttribute("patient", patientServiceImpl.findPatientById(1L));
        model.addAttribute("nursepatients", patientServiceImpl.findAllByNurse(nurseServiceImpl.findNurseById(1L)));
        model.addAttribute("agencies", agencyServiceImpl.findAll());
        return "dashboard";
    }



}
