package com.ronnyalfonso.nursereports.nursereports.services;

import com.ronnyalfonso.nursereports.nursereports.domain.Nurse;
import com.ronnyalfonso.nursereports.nursereports.domain.NursePayment;

import java.util.List;

/**
 * By Ron on 9/9/2018
 */
public interface NursePaymentService {

    NursePayment save(NursePayment nursePayment);

    List<NursePayment> findAllByNurse(Nurse nurse);

    List<NursePayment> findAll();
}
