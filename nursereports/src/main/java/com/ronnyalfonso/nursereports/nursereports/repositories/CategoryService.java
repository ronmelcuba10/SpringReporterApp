package com.ronnyalfonso.nursereports.nursereports.repositories;

import com.ronnyalfonso.nursereports.nursereports.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * By Ron on 9/9/2018
 */
@Repository
public interface CategoryService extends JpaRepository<Category, Long> {
}
