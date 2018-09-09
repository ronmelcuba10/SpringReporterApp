package com.ronnyalfonso.nursereports.nursereports.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/**
 * By Ron on 9/3/2018
 */
@Entity
@Data
public class Nurse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String userName;
    private String password;
    //private License license;

    @OneToMany(mappedBy = "nurse")
    private List<NurseAgency> agencies = new ArrayList<>();

    public void addAgency(Agency agency) {
        NurseAgency nurseAgency = new NurseAgency();
        nurseAgency.setAgency(agency);
        nurseAgency.setNurse(this);
        agencies.add(nurseAgency);
        agency.getNurses().add(nurseAgency);
    }

    public void removeAgency(Agency agency) {
        for (Iterator<NurseAgency> iterator = agencies.iterator(); iterator.hasNext(); ) {
            NurseAgency nurseAgency = iterator.next();
            if (nurseAgency.getNurse().equals(this) && nurseAgency.getAgency().equals(agency)){
                iterator.remove();
                nurseAgency.getAgency().getNurses().remove(nurseAgency);
                nurseAgency.setNurse(null);
                nurseAgency.setAgency(null);
            }
        }
    }


}
