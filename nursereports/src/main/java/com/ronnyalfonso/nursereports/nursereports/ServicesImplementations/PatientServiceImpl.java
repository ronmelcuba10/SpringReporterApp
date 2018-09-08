package com.ronnyalfonso.nursereports.nursereports.ServicesImplementations;

import com.ronnyalfonso.nursereports.nursereports.domain.Nurse;
import com.ronnyalfonso.nursereports.nursereports.domain.Patient;
import com.ronnyalfonso.nursereports.nursereports.repositories.PatientRepository;
import com.ronnyalfonso.nursereports.nursereports.services.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * By Ron on 9/8/2018
 */
@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient findPatientById(Long id) {
        return patientRepository.getOne(1L);
    }

    @Override
    public List<Patient> findAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public List<Patient> findAllByNurse(Nurse nurse) {
        return patientRepository.findAllByNurse(nurse);
    }
}
