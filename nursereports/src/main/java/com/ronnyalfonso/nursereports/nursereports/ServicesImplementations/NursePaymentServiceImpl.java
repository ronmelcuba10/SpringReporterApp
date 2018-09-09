package com.ronnyalfonso.nursereports.nursereports.ServicesImplementations;

import com.ronnyalfonso.nursereports.nursereports.domain.Nurse;
import com.ronnyalfonso.nursereports.nursereports.domain.NursePayment;
import com.ronnyalfonso.nursereports.nursereports.repositories.NursePaymentRepository;
import com.ronnyalfonso.nursereports.nursereports.services.NursePaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * By Ron on 9/9/2018
 */
@Service
public class NursePaymentServiceImpl implements NursePaymentService {

    private final NursePaymentRepository nursePaymentRepository;

    public NursePaymentServiceImpl(NursePaymentRepository nursePaymentRepository) {
        this.nursePaymentRepository = nursePaymentRepository;
    }

    @Override
    public NursePayment save(NursePayment nursePayment) {
        return nursePaymentRepository.save(nursePayment);
    }

    @Override
    public List<NursePayment> findAllByNurse(Nurse nurse) {
        return nursePaymentRepository.findAllByNurse(nurse);
    }

    @Override
    public List<NursePayment> findAll() {
        return nursePaymentRepository.findAll();
    }
}
