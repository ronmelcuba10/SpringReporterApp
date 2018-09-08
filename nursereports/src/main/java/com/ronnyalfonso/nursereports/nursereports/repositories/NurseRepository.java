package com.ronnyalfonso.nursereports.nursereports.repositories;

import com.ronnyalfonso.nursereports.nursereports.domain.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * By Ron on 9/3/2018
 */
@Repository
public interface NurseRepository extends JpaRepository<Nurse, Long> {

    //@Query("SELECT n FROM Nurse WHERE n.userName = :userName AND n.password = :password")
    Nurse findByUserNameAndPassword(@Param("userName") String  userName,
                                    @Param("password") String password);
}
