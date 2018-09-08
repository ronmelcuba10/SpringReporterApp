package com.ronnyalfonso.nursereports.nursereports.repositories;

import com.ronnyalfonso.nursereports.nursereports.domain.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * By Ron on 9/3/2018
 */
@Repository
public interface NurseRepository extends JpaRepository<Nurse, Long> {
}
