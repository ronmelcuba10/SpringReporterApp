package com.ronnyalfonso.nursereports.nursereports.repositories;

import com.ronnyalfonso.nursereports.nursereports.domain.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * By Ron on 9/8/2018
 */
@Repository
public interface AgencyRepository extends JpaRepository <Agency, Long> {
}
