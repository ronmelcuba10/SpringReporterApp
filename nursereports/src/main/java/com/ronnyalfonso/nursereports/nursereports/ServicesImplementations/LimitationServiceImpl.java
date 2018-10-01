package com.ronnyalfonso.nursereports.nursereports.ServicesImplementations;

import com.ronnyalfonso.nursereports.nursereports.domain.Limitation;
import com.ronnyalfonso.nursereports.nursereports.domain.Patient;
import com.ronnyalfonso.nursereports.nursereports.repositories.LimitationRepository;
import com.ronnyalfonso.nursereports.nursereports.services.LimitationService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * By Ron on 9/9/2018
 */
@Service
public class LimitationServiceImpl implements LimitationService {

    private final LimitationRepository limitationRepository;

    public LimitationServiceImpl(LimitationRepository limitationRepository) {
        this.limitationRepository = limitationRepository;
    }


    @Override
    public Limitation save(Limitation limitation) {
        return limitationRepository.save(limitation);
    }

    @Override
    public List<Limitation> findAll() {
        return limitationRepository.findAll();
    }

}
