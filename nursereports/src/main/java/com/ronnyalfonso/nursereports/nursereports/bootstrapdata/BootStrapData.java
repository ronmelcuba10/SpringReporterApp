package com.ronnyalfonso.nursereports.nursereports.bootstrapdata;

import com.ronnyalfonso.nursereports.nursereports.domain.*;
import com.ronnyalfonso.nursereports.nursereports.domain.enumerators.Assistant;
import com.ronnyalfonso.nursereports.nursereports.domain.enumerators.License;
import com.ronnyalfonso.nursereports.nursereports.domain.enumerators.Month;
import com.ronnyalfonso.nursereports.nursereports.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final LimitationRepository limitationRepository;


    public BootStrapData(NurseRepository nurseRepository, PatientRepository patientRepository, AgencyRepository agencyRepository, NurseAgencyRepository nurseAgencyRepository, NursePaymentRepository nursePaymentRepository, LimitationRepository limitationRepository) {
        this.nurseRepository = nurseRepository;
        this.patientRepository = patientRepository;
        this.agencyRepository = agencyRepository;
        this.nurseAgencyRepository = nurseAgencyRepository;
        this.nursePaymentRepository = nursePaymentRepository;
        this.limitationRepository = limitationRepository;
    }




    @Override
    public void run(String... args) throws Exception {

        System.out.println("Loading agencies ");
        ArrayList<Agency> agencies = GetAgencies();

        System.out.println("Loading Nurses ");
        ArrayList<Nurse> nurses = GetNurses(agencies);

        System.out.println("Saving the limitations");
        ArrayList<Limitation> limitations = GetLimitations();

        System.out.println("Loading Patients ");
        ArrayList<Patient> patients = GetPatients(nurses);


        nurses.stream().forEach( n -> nurseRepository.save(n));
        agencies.stream().forEach( a -> agencyRepository.save(a));
        limitations.stream().forEach( l -> limitationRepository.save(l));
        patients.stream().forEach( p -> patientRepository.save(p));

        System.out.println("registering nurse payments");
        ArrayList<NursePayment> payments = SetNurseAndPayments(nurses);

        payments.stream().forEach( p-> nursePaymentRepository.save(p));


        // Patients limitations
        patients.get(0).getLimitations().add(limitations.get(0));
        patients.get(0).getLimitations().add(limitations.get(1));
        patients.get(0).getLimitations().add(limitations.get(2));

        patients.get(1).getLimitations().add(limitations.get(1));
        patients.get(1).getLimitations().add(limitations.get(2));
        patients.get(1).getLimitations().add(limitations.get(3));

        patients.get(2).getLimitations().add(limitations.get(1));
        patients.get(2).getLimitations().add(limitations.get(4));
        patients.get(2).getLimitations().add(limitations.get(3));
        patients.get(2).getLimitations().add(limitations.get(2));
        patients.stream().forEach( p -> patientRepository.save(p));

        /*
        nurses.get(0).addAgency(agencies.get(0), "Nurse0Agency0");
        nurses.get(0).addAgency(agencies.get(1), "Nurse0Agency1");
        nurses.get(0).addAgency(agencies.get(2), "Nurse0Agency2");

        nurses.get(1).addAgency(agencies.get(0), "Nurse1Agency0");
        nurses.get(1).addAgency(agencies.get(1), "Nurse1Agency1");

        nurses.get(2).addAgency(agencies.get(0), "Nurse2Agency0");
        nurses.get(2).addAgency(agencies.get(1), "Nurse2Agency1");
        nurses.get(2).addAgency(agencies.get(2), "Nurse2Agency2");
        nurses.stream().forEach( n -> nurseRepository.save(n));
        */

        /*
        NurseAgency na = new NurseAgency();
        na.setNurse(nurses.get(0));
        na.setAgency(agencies.get(0));
        na.setNurseRecord("Nurse0Agency0");
        nurses.get(0).getAgencies().add(na);
        agencies.get(0).getNurses().add(na);
        nurseRepository.save(nurses.get(0));
        agencyRepository.save(agencies.get(0));
        */

    }


    private ArrayList<Agency> GetAgencies() {

        ArrayList<Agency> agencies = new ArrayList<>(3);

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

    private ArrayList<Nurse> GetNurses(ArrayList<Agency> agencies) {

        ArrayList<Nurse> nurses = new ArrayList<>(3);

        Nurse n1 = new Nurse();
        n1.setFirstName("Mario");
        n1.setMiddleName("P");
        n1.setLastName("Perez");
        n1.setUserName("mario");
        n1.setPassword("mario123");
        n1.setLicense(License.LPN);

        //n1.addAgency(agencies.get(0));
        //n1.addAgency(agencies.get(1));
        nurses.add(n1);

        Nurse n2 = new Nurse();
        n2.setFirstName("Luis");
        n2.setMiddleName("");
        n2.setLastName("Ruiz");
        n2.setUserName("luis");
        n2.setPassword("luis123");
        n2.setLicense(License.RN);
        //n2.addAgency(agencies.get(1));
        nurses.add(n2);

        Nurse n3 = new Nurse();
        n3.setFirstName("Maria");
        n3.setMiddleName("");
        n3.setLastName("Crez");
        n3.setUserName("maria");
        n3.setPassword("maria123");
        n3.setLicense(License.LPN);
        //n3.addAgency(agencies.get(0));
        //n3.addAgency(agencies.get(1));
        //n3.addAgency(agencies.get(2));
        nurses.add(n3);

        return nurses;
    }

    private ArrayList<Limitation> GetLimitations(){

        ArrayList<Limitation> limitations = new ArrayList<>(5);

        Limitation l1 = new Limitation();
        l1.setName("blindness");
        limitations.add(l1);

        Limitation l2 = new Limitation();
        l2.setName("hand tremors");
        limitations.add(l2);

        Limitation l3 = new Limitation();
        l3.setName("poor hand coordination");
        limitations.add(l3);

        Limitation l4 = new Limitation();
        l4.setName("poor manual dexterity");
        limitations.add(l4);

        Limitation l5 = new Limitation();
        l5.setName("mental status");
        limitations.add(l5);

        return limitations;


    }

    private ArrayList<Patient> GetPatients(ArrayList<Nurse> nurses) {

        ArrayList<Patient> patients = new ArrayList<>(4);

        Patient p1 = new Patient();
        p1.setFirstName("Pepe");
        p1.setMiddleName("J");
        p1.setLastName("Mirabal");
        p1.setNurse(nurses.get(0));
        p1.setAssistant(Assistant.patient);
        patients.add(p1);

        Patient p2 = new Patient();
        p2.setFirstName("Luisa");
        p2.setMiddleName("");
        p2.setLastName("Montes");
        p2.setNurse(nurses.get(0));
        p2.setAssistant(Assistant.ALF_staff);
        patients.add(p2);

        Patient p3 = new Patient();
        p3.setFirstName("Gisela");
        p3.setMiddleName("");
        p3.setLastName("Glez");
        p3.setNurse(nurses.get(1));
        p3.setAssistant(Assistant.caregiver);
        patients.add(p3);

        Patient p4 = new Patient();
        p4.setFirstName("Teresa");
        p4.setMiddleName("");
        p4.setLastName("Prio");
        p4.setNurse(nurses.get(0));
        patients.add(p4);

        return patients;
    }

    private ArrayList<NurseAgency> SetNurseAndAgencies(Nurse nurse, Agency[] agencies) {

        ArrayList<NurseAgency> nurseagencies = new ArrayList<>(agencies.length);

        for (int i=0; i<agencies.length; i++){
            NurseAgency na = new NurseAgency();
            na.setNurse(nurse);
            na.setAgency(agencies[i]);
            na.setNurseRecord(nurse.getFirstName() + agencies[i].getName());
            nurseagencies.add(na);
            //nurse.getAgencies().add(na);
            //agencies[i].getNurses().add(na);
        }
        return nurseagencies;
    }

    private ArrayList<NursePayment> SetNurseAndPayments(ArrayList<Nurse> nurses){

        ArrayList<NursePayment> payments = new ArrayList<>();

        NursePayment np1 = new NursePayment();
        np1.setNurse(nurses.get(0));
        np1.setMonth(Month.APRIL);
        np1.setAmount( new BigDecimal("50.0"));
        np1.setYear(2018);
        payments.add(np1);

        NursePayment np2 = new NursePayment();
        np2.setNurse(nurses.get(0));
        np2.setMonth(Month.MAY);
        np2.setAmount( new BigDecimal("50.0"));
        np2.setYear(2018);
        payments.add(np2);

        NursePayment np3 = new NursePayment();
        np3.setNurse(nurses.get(0));
        np3.setMonth(Month.JUNE);
        np3.setAmount( new BigDecimal("50.0"));
        np3.setYear(2018);
        payments.add(np3);

        NursePayment np4 = new NursePayment();
        np4.setNurse(nurses.get(1));
        np4.setMonth(Month.APRIL);
        np4.setAmount( new BigDecimal("50.0"));
        np4.setYear(2018);
        payments.add(np4);

        NursePayment np5 = new NursePayment();
        np5.setNurse(nurses.get(2));
        np5.setMonth(Month.APRIL);
        np5.setAmount( new BigDecimal("50.0"));
        np5.setYear(2018);
        payments.add(np5);

        NursePayment np6 = new NursePayment();
        np6.setNurse(nurses.get(2));
        np6.setMonth(Month.MAY);
        np6.setAmount( new BigDecimal("18.0"));
        np6.setYear(2018);
        payments.add(np6);

        return payments;

    }




}


