package com.ronnyalfonso.nursereports.nursereports.repositories;

import com.ronnyalfonso.nursereports.nursereports.domain.NurseAgency;
import com.ronnyalfonso.nursereports.nursereports.domain.NurseAgencyIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * By Ron on 9/8/2018
 */
@Repository
public interface NurseAgencyRepository extends JpaRepository<NurseAgency, NurseAgencyIdentity> {
}
