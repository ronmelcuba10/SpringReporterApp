package com.ronnyalfonso.nursereports.nursereports.ServicesImplementations;

import com.ronnyalfonso.nursereports.nursereports.domain.Agency;
import com.ronnyalfonso.nursereports.nursereports.repositories.AgencyRepository;
import com.ronnyalfonso.nursereports.nursereports.services.AgencyService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * By Ron on 9/8/2018
 */
@Service
public class AgencyServiceImpl implements AgencyService {

    private final AgencyRepository agencyRepository;

    public AgencyServiceImpl(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public List<Agency> findAll() {
        return agencyRepository.findAll();
    }

    @Override
    public Agency findAgencyById(Long id) {
        return agencyRepository.getOne(id);
    }
}
