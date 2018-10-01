package com.ronnyalfonso.nursereports.nursereports.ServicesImplementations;

import com.ronnyalfonso.nursereports.nursereports.domain.Agency;
import com.ronnyalfonso.nursereports.nursereports.domain.Nurse;
import com.ronnyalfonso.nursereports.nursereports.repositories.NurseAgencyRepository;
import com.ronnyalfonso.nursereports.nursereports.services.NurseAgencyService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * By Ron on 10/1/2018
 */
@Service
public class NurseAgencyServiceImpl implements NurseAgencyService {

    private final NurseAgencyRepository nurseAgencyRepository;

    public NurseAgencyServiceImpl(NurseAgencyRepository nurseAgencyRepository) {
        this.nurseAgencyRepository = nurseAgencyRepository;
    }

    @Override
    public List<Agency> findAllByNurse(Nurse nurse) {
        return findAllByNurse(nurse);
    }
}
