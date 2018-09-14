package com.ronnyalfonso.nursereports.nursereports.repositories;

import com.ronnyalfonso.nursereports.nursereports.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * By Ron on 9/13/2018
 */
@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
