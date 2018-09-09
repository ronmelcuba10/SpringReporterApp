package com.ronnyalfonso.nursereports.nursereports.bootstrapdata;

import com.ronnyalfonso.nursereports.nursereports.domain.*;
import com.ronnyalfonso.nursereports.nursereports.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * By Ron on 9/5/2018
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final NurseRepository nurseRepository;
    private final PatientRepository patientRepository;
    private final AgencyRepository agencyRepository;
    private final NurseAgencyRepository nurseAgencyRepository;
    private final NursePaymentRepository nursePaymentRepository;

    public BootStrapData(NurseRepository nurseRepository, PatientRepository patientRepository, AgencyRepository agencyRepository, NurseAgencyRepository nurseAgencyRepository, NursePaymentRepository nursePaymentRepository) {
        this.nurseRepository = nurseRepository;
        this.patientRepository = patientRepository;
        this.agencyRepository = agencyRepository;
        this.nurseAgencyRepository = nurseAgencyRepository;
        this.nursePaymentRepository = nursePaymentRepository;
    }




    @Override
    public void run(String... args) throws Exception {

        ArrayList<Agency> agencies = GetAgencies();
        agencies.stream().forEach( a -> agencyRepository.save(a));
        System.out.println(" Agencies saved: " + agencyRepository.count());
        //agencies = (ArrayList<Agency>)agencyRepository.findAll();

        ArrayList<Nurse> nurses = GetNurses(agencies);
        nurses.stream().forEach( n -> nurseRepository.save(n));
        System.out.println(" Nurses saved: " + nurseRepository.count());
        //nurses = (ArrayList<Nurse>)nurseRepository.findAll();

        GetNursePayments(nurses).stream().forEach( p -> nursePaymentRepository.save(p));
        System.out.println(" Nurse's payments saved: " + nursePaymentRepository.count());

        //GetNurseAgencies( nurses.get(0), new Agency[] {agencies.get(0), agencies.get(1)}).stream().forEach( na -> nurseAgencyRepository.save(na));
        //GetNurseAgencies( nurses.get(1), new Agency[] {agencies.get(0), agencies.get(1)}).stream().forEach( na -> nurseAgencyRepository.save(na));
        //GetNurseAgencies( nurses.get(2), new Agency[] {agencies.get(0), agencies.get(1), agencies.get(2)}).stream().forEach( na -> nurseAgencyRepository.save(na));

        //ArrayList<Patient> patients = new ArrayList<>(4);
        GetPatients(nurses).stream().forEach( p -> patientRepository.save(p));
        System.out.println(" Patient saved: " + patientRepository.count());

    }

    private ArrayList<NurseAgency> GetNurseAgencies(ArrayList<Nurse> nurses, ArrayList<Agency> agencies) {

        System.out.println("Registering the nurses in their agencies");

        ArrayList<NurseAgency> nurseAgencies = new ArrayList<>(3);

        NurseAgency na1 = new NurseAgency();
        na1.setNurse(nurses.get(0));
        na1.setAgency(agencies.get(0));
        nurseAgencies.add(na1);

        NurseAgency na2 = new NurseAgency();
        na2.setNurse(nurses.get(0));
        na2.setAgency(agencies.get(1));
        nurseAgencies.add(na2);

        NurseAgency na3 = new NurseAgency();
        na3.setNurse(nurses.get(1));
        na3.setAgency(agencies.get(1));
        nurseAgencies.add(na3);

        NurseAgency na4 = new NurseAgency();
        na4.setNurse(nurses.get(1));
        na4.setAgency(agencies.get(2));
        nurseAgencies.add(na4);

        NurseAgency na5 = new NurseAgency();
        na5.setNurse(nurses.get(2));
        na5.setAgency(agencies.get(0));
        nurseAgencies.add(na5);

        NurseAgency na6 = new NurseAgency();
        na6.setNurse(nurses.get(2));
        na6.setAgency(agencies.get(1));
        nurseAgencies.add(na6);

        NurseAgency na7 = new NurseAgency();
        na7.setNurse(nurses.get(2));
        na7.setAgency(agencies.get(2));
        nurseAgencies.add(na7);

        System.out.println("The Nurses were registered successfully");

        return nurseAgencies;


    }

    private ArrayList<Agency> GetAgencies() {

        ArrayList<Agency> agencies = new ArrayList<>(3);

        System.out.println("Loading agencies ");

        Agency a1 = new Agency();
        a1.setName("Agency 1");
        agencies.add(a1);

        Agency a2 = new Agency();
        a2.setName("Agency 2");
        agencies.add(a2);

        Agency a3 = new Agency();
        a3.setName("Agency 3");
        agencies.add(a3);

        return agencies;
    }

    private ArrayList<Patient> GetPatients(ArrayList<Nurse> nurses) {

        ArrayList<Patient> patients = new ArrayList<>(4);

        System.out.println("Loading Patients ");

        Patient p1 = new Patient();
        p1.setFirstName("Pepe");
        p1.setMiddleName("J");
        p1.setLastName("Mirabal");
        p1.setNurse(nurses.get(0));
        patients.add(p1);

        Patient p2 = new Patient();
        p2.setFirstName("Luisa");
        p2.setMiddleName("");
        p2.setLastName("Montes");
        p2.setNurse(nurses.get(0));
        patients.add(p2);

        Patient p3 = new Patient();
        p3.setFirstName("Gisela");
        p3.setMiddleName("");
        p3.setLastName("Glez");
        p3.setNurse(nurses.get(1));
        patients.add(p3);

        Patient p4 = new Patient();
        p4.setFirstName("Teresa");
        p4.setMiddleName("");
        p4.setLastName("Prio");
        p4.setNurse(nurses.get(0));
        patients.add(p4);

        return patients;
    }

    private ArrayList<Nurse> GetNurses(ArrayList<Agency> agencies) {

        ArrayList<Nurse> nurses = new ArrayList<>(3);

        System.out.println("Loading Nurses ");

        Nurse n1 = new Nurse();
        n1.setFirstName("Mario");
        n1.setMiddleName("P");
        n1.setLastName("Perez");
        n1.setUserName("mario");
        n1.setPassword("mario123");

        //n1.addAgency(agencies.get(0));
        //n1.addAgency(agencies.get(1));
        nurses.add(n1);

        Nurse n2 = new Nurse();
        n2.setFirstName("Luis");
        n2.setMiddleName("");
        n2.setLastName("Ruiz");
        n2.setUserName("luis");
        n2.setPassword("luis123");
        //n2.addAgency(agencies.get(1));
        nurses.add(n2);

        Nurse n3 = new Nurse();
        n3.setFirstName("Maria");
        n3.setMiddleName("");
        n3.setLastName("Crez");
        n3.setUserName("maria");
        n3.setPassword("maria123");
        //n3.addAgency(agencies.get(0));
        //n3.addAgency(agencies.get(1));
        //n3.addAgency(agencies.get(2));
        nurses.add(n3);

        return nurses;
    }

    private ArrayList<NursePayment> GetNursePayments(ArrayList<Nurse> nurses){

        System.out.println("registering nurse payments");

        ArrayList<NursePayment> payments = new ArrayList<>(nurses.size());

        NursePayment np1 = new NursePayment();
        np1.setNurse(nurses.get(0));
        np1.setMonth(Month.April);
        np1.setAmount( new BigDecimal("50.0"));
        np1.setYear(2018);
        payments.add(np1);

        NursePayment np2 = new NursePayment();
        np2.setNurse(nurses.get(0));
        np2.setMonth(Month.May);
        np2.setAmount( new BigDecimal("50.0"));
        np2.setYear(2018);
        payments.add(np2);

        NursePayment np3 = new NursePayment();
        np3.setNurse(nurses.get(0));
        np3.setMonth(Month.June);
        np3.setAmount( new BigDecimal("50.0"));
        np3.setYear(2018);
        payments.add(np3);

        NursePayment np4 = new NursePayment();
        np4.setNurse(nurses.get(1));
        np4.setMonth(Month.April);
        np4.setAmount( new BigDecimal("50.0"));
        np4.setYear(2018);
        payments.add(np4);

        NursePayment np5 = new NursePayment();
        np5.setNurse(nurses.get(2));
        np5.setMonth(Month.April);
        np5.setAmount( new BigDecimal("50.0"));
        np5.setYear(2018);
        payments.add(np5);

        NursePayment np6 = new NursePayment();
        np6.setNurse(nurses.get(2));
        np6.setMonth(Month.May);
        np6.setAmount( new BigDecimal("18.0"));
        np6.setYear(2018);
        payments.add(np6);

        return payments;

    }



    private ArrayList<NurseAgency> GetNurseAgencies(Nurse nurse, Agency[] agencies){
        ArrayList<NurseAgency> nas = new ArrayList<>(agencies.length);
        Arrays.stream(agencies).forEach( agency -> {
            NurseAgency na = new NurseAgency();
            na.setAgency(agency);
            na.setNurse(nurse);
            na.setNurseRecord(nurse.getFirstName() + agency.getName());
            nas.add(na);
        });
        return nas;

    }




}
