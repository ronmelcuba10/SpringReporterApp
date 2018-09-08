package com.ronnyalfonso.nursereports.nursereports.services;

import com.ronnyalfonso.nursereports.nursereports.domain.Nurse;
import com.ronnyalfonso.nursereports.nursereports.domain.Patient;

import java.util.List;

/**
 * By Ron on 9/8/2018
 */
public interface PatientService {

    Patient findPatientById(Long id);

    List<Patient> findAllPatient();

    List<Patient> findAllByNurse(Nurse nurse);
}
