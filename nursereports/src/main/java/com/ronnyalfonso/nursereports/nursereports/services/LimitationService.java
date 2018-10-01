package com.ronnyalfonso.nursereports.nursereports.services;

import com.ronnyalfonso.nursereports.nursereports.domain.Limitation;

import java.util.List;

/**
 * By Ron on 9/9/2018
 */
public interface LimitationService {

    Limitation save(Limitation limitation);

    List<Limitation> findAll();

}
