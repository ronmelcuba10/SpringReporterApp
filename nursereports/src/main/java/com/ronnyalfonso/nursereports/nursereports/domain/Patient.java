package com.ronnyalfonso.nursereports.nursereports.domain;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

/**
 * By Ron on 9/8/2018
 */
@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;

    // Vital Sign Ranges
    private Integer maxDiastolic;
    private Integer minDiastolic;
    private Integer maxSystolic;
    private Integer minSystolic;
    private Integer maxBloodSugarLevel;
    private Integer minBloodSugarLevel;
    private Float maxTemperature;
    private Float minTemperature;
    private Integer maxPulse;
    private Integer minPulse;
    private Integer maxRespiration;
    private Integer minRespiration;
    private Boolean bedBound;
    private Boolean isActive;
    private Boolean isDeleted;
    private Boolean paid;

    @ManyToOne(optional = false)
    @JoinColumn(name = "nurse_id", nullable = false)
    private Nurse nurse;
    //private AssistantType assistantType;

}
