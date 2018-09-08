package com.ronnyalfonso.nursereports.nursereports.bootstrapdata;

import com.ronnyalfonso.nursereports.nursereports.domain.Nurse;
import com.ronnyalfonso.nursereports.nursereports.domain.Patient;
import com.ronnyalfonso.nursereports.nursereports.repositories.NurseRepository;
import com.ronnyalfonso.nursereports.nursereports.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * By Ron on 9/5/2018
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final NurseRepository nurseRepository;

    private final PatientRepository patientRepository;

    public BootStrapData(NurseRepository nurseRepository, PatientRepository patientRepository) {
        this.nurseRepository = nurseRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading Nurses ");

        Nurse n1 = new Nurse();
        n1.setFirstName("Mario");
        n1.setMiddleName("P");
        n1.setLastName("Perez");
        n1.setUserName("mario");
        n1.setPassword("mario123");
        nurseRepository.save(n1);

        Nurse n2 = new Nurse();
        n2.setFirstName("Luis");
        n2.setMiddleName("");
        n2.setLastName("Ruiz");
        n2.setUserName("luis");
        n2.setPassword("luis123");
        nurseRepository.save(n2);

        Nurse n3 = new Nurse();
        n3.setFirstName("Maria");
        n3.setMiddleName("");
        n3.setLastName("Crez");
        n3.setUserName("maria");
        n3.setPassword("maria123");
        nurseRepository.save(n3);

        System.out.println(" Nurses saved: " + nurseRepository.count());




        System.out.println("Loading Patients ");

        Patient p1 = new Patient();
        p1.setFirstName("Pepe");
        p1.setMiddleName("J");
        p1.setLastName("Mirabal");
        p1.setNurse(n1);
        patientRepository.save(p1);

        Patient p2 = new Patient();
        p2.setFirstName("Luisa");
        p2.setMiddleName("");
        p2.setLastName("Montes");
        p2.setNurse(n1);
        patientRepository.save(p2);

        Patient p3 = new Patient();
        p3.setFirstName("Gisela");
        p3.setMiddleName("");
        p3.setLastName("Glez");
        p3.setNurse(n2);
        patientRepository.save(p3);

        Patient p4 = new Patient();
        p4.setFirstName("Teresa");
        p4.setMiddleName("");
        p4.setLastName("Prio");
        p4.setNurse(n1);
        patientRepository.save(p4);




        System.out.println(" Patient saved: " + patientRepository.count());
    }


}
