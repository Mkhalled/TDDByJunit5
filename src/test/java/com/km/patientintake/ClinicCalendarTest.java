package com.km.patientintake;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClinicCalendarTest {

    private ClinicCalendar clinicCalendar;

    @BeforeEach
    void init() {
        clinicCalendar = new ClinicCalendar(LocalDate.of(2018, 8, 26));
    }

    @Test
    public void allowEntryOfAnAppointment(){

        clinicCalendar.addAppointment("khalled","meneouali","avery","09/01/2019 2:00 pm");
        List<PatientAppointment> appointments=clinicCalendar.getAppointments();
        assertNotNull(appointments);
        assertEquals(1,appointments.size());
        PatientAppointment patientAppointment=appointments.get(0);

        assertAll(
                ()-> assertEquals("khalled",patientAppointment.getPatientFirstName()),
                ()-> assertEquals("meneouali",patientAppointment.getPatientLastName()),
                ()-> assertEquals(Doctor.avery,patientAppointment.getDoctor()),
                ()-> assertEquals("9/1/2019 02:00 PM",patientAppointment.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a")))
        );
    }

    @Test
    void returnTrueForHasAppointmentsIfThereAreAppointments() {

        clinicCalendar.addAppointment("Jim", "Weaver", "avery",
                "09/01/2018 2:00 pm");
        assertTrue(clinicCalendar.hasAppointment(LocalDate.of(2018, 9, 1)));
    }

    @Test
    void returnFalseForHasAppointmentsIfThereAreNoAppointments() {

        assertFalse(clinicCalendar.hasAppointment(LocalDate.of(2018, 9, 1)));
    }

    @Test
    void returnCurrentDaysAppointments() {
        clinicCalendar.addAppointment("Jim", "Weaver", "avery",
                "08/26/2018 2:00 pm");
        clinicCalendar.addAppointment("Jim", "Weaver", "avery",
                "08/26/2018 3:00 pm");
        clinicCalendar.addAppointment("Jim", "Weaver", "avery",
                "09/01/2018 2:00 pm");
        assertEquals(2, clinicCalendar.getToDayAppointments().size());
    }
}