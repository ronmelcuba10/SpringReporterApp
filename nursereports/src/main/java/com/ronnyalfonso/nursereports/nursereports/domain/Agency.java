package com.ronnyalfonso.nursereports.nursereports.domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * By Ron on 9/8/2018
 */
@Entity
@Data
public class Agency extends Named{

    private String description;
    private Boolean tested;
    private Boolean active;
    private String reportUrl;

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NurseAgency> nurses = new ArrayList<>();

}
