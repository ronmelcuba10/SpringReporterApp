package com.ronnyalfonso.nursereports.nursereports.services;

import com.ronnyalfonso.nursereports.nursereports.domain.Agency;

import java.util.List;

/**
 * By Ron on 9/8/2018
 */
public interface AgencyService {

    List<Agency> findAll();

    Agency findAgencyById(Long id);
}
