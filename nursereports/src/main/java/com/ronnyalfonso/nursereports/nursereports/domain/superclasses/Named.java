package com.ronnyalfonso.nursereports.nursereports.domain.superclasses;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * By Ron on 9/8/2018
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class Named implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
