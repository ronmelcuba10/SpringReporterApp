package com.ronnyalfonso.nursereports.nursereports.repositories;

import com.ronnyalfonso.nursereports.nursereports.domain.Limitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * By Ron on 9/9/2018
 */
@Repository
public interface LimitationRepository extends JpaRepository<Limitation, Long> {
}
