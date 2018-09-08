package com.ronnyalfonso.nursereports.nursereports.repositories;

import com.ronnyalfonso.nursereports.nursereports.domain.Nurse;
import com.ronnyalfonso.nursereports.nursereports.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * By Ron on 9/8/2018
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findAllByNurse(Nurse nurse);
}
