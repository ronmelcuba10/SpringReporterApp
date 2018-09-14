package com.ronnyalfonso.nursereports.nursereports.domain.identities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * By Ron on 9/8/2018
 */
@Embeddable
@Data
public class NurseAgencyIdentity implements Serializable {

    @Column(name="nurse_id")
    private Long nurseId;

    @Column(name="agency_id")
    private Long agencyId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NurseAgencyIdentity that = (NurseAgencyIdentity) o;
        return Objects.equals(nurseId, that.nurseId) &&
                Objects.equals(agencyId, that.agencyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nurseId, agencyId);
    }
}
