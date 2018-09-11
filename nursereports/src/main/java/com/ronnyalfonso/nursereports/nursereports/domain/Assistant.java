package com.ronnyalfonso.nursereports.nursereports.domain;

/**
 * By Ron on 9/9/2018
 */
public enum Assistant {
    patient,
    caregiver,
    ALF_staff {
        public String toString(){
            return "ALF staff";
        }
    },
}
