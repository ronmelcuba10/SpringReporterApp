package com.ronnyalfonso.nursereports.nursereports.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * By Ron on 9/8/2018
 */
@Entity
@Data
public class NurseAgency implements Serializable {

    @EmbeddedId
    private NurseAgencyIdentity id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("nurseId")
    //@JoinColumn(name = "nurse_id", nullable = false)
    private Nurse nurse;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("agencyId")
    //@JoinColumn(name = "agency_id", nullable = false)
    private Agency agency;

    private String nurseRecord;

}
