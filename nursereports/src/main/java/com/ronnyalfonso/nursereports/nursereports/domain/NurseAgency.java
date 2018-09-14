package com.ronnyalfonso.nursereports.nursereports.domain;

import com.ronnyalfonso.nursereports.nursereports.domain.identities.NurseAgencyIdentity;
import lombok.Data;

import javax.persistence.*;

/**
 * By Ron on 9/8/2018
 */
@Entity
@Data
public class NurseAgency {

    @EmbeddedId
    private NurseAgencyIdentity id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("nurseId")
    private Nurse nurse;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("agencyId")
    private Agency agency;

    private String nurseRecord;

}
