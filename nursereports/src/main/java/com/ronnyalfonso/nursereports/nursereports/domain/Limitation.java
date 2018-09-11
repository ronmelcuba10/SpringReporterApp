package com.ronnyalfonso.nursereports.nursereports.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * By Ron on 9/9/2018
 */
@Entity
@Data
public class Limitation extends Named{

    @ManyToMany(mappedBy = "limitations")
    List<Patient> patients = new ArrayList<>();
}
