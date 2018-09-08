package com.ronnyalfonso.nursereports.nursereports.ServicesImplementations;

import com.ronnyalfonso.nursereports.nursereports.domain.Nurse;
import com.ronnyalfonso.nursereports.nursereports.domain.Login;
import com.ronnyalfonso.nursereports.nursereports.repositories.NurseRepository;
import com.ronnyalfonso.nursereports.nursereports.services.NurseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * By Ron on 9/3/2018
 */
@Service
public class NurseServiceImpl implements NurseService {

    private final NurseRepository nurseRepository;

    public NurseServiceImpl(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }

    @Override
    public Nurse findNurseById(Long id) {
        return nurseRepository.getOne(id);
    }

    @Override
    public List<Nurse> findAllNurse() {
        return nurseRepository.findAll();
    }


    public void register(Nurse nurse) {
    }

    public Nurse validateNurse(Login login) {
        return new Nurse();
    }
}
