package com.ronnyalfonso.nursereports.nursereports.services;


import com.ronnyalfonso.nursereports.nursereports.domain.Agency;
import com.ronnyalfonso.nursereports.nursereports.domain.Nurse;

import java.util.List;

/**
 * By Ron on 10/1/2018
 */
public interface NurseAgencyService {

    List<Agency> findAllByNurse(Nurse nurse);
}
