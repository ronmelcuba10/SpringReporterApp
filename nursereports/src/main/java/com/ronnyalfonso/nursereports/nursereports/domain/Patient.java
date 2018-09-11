package com.ronnyalfonso.nursereports.nursereports.domain;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Enumerated(EnumType.STRING)
    private Assistant assistant;

    @ManyToOne(optional = false)
    @JoinColumn(name = "nurse_id", nullable = false)
    private Nurse nurse;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            joinColumns = @JoinColumn(name="patient_id"),
            inverseJoinColumns = @JoinColumn( name="limitation_id")
    )
    List<Limitation> limitations = new ArrayList<>();

    @Override
    public String toString(){
        return String.format("%s %s %s", firstName, middleName, lastName);
    }

}
