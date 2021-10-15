package com.km.patientintake;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClinicCalendarTest {

    @Test
    public void allowEntryOfAnAppointment(){
        ClinicCalendar clinicCalendar=new ClinicCalendar();
        clinicCalendar.addAppointment("khalled","meneouali","avery","09/01/2019 2:00 pm");
        List<PatientAppointment> appointments=clinicCalendar.getAppointments();
        assertNotNull(appointments);
        assertEquals(1,appointments.size());
        PatientAppointment patientAppointment=appointments.get(0);
        assertEquals("khalled",patientAppointment.getPatientFirstName());
        assertEquals("meneouali",patientAppointment.getPatientLastName());
        assertEquals(Doctor.avery,patientAppointment.getDoctor());
        assertEquals("9/1/2019 02:00 PM",patientAppointment.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a")));
    }

}