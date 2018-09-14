package com.ronnyalfonso.nursereports.nursereports.domain.enumerators;

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
