package com.ronnyalfonso.nursereports.nursereports.services;

import com.ronnyalfonso.nursereports.nursereports.domain.Nurse;

import java.util.List;

/**
 * By Ron on 9/3/2018
 */
public interface NurseService {

    Nurse findNurseById(Long id);

    List<Nurse> findAllNurse();


}
