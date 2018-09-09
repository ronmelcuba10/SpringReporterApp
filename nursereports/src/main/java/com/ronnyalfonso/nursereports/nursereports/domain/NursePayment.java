package com.ronnyalfonso.nursereports.nursereports.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * By Ron on 9/9/2018
 */
@Entity
@Data
public class NursePayment {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nurse_id", nullable = false)
    private Nurse nurse;

    private Month month;
    private Integer year;
    private BigDecimal amount;

}
