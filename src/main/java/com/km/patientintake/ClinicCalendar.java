package com.km.patientintake;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ClinicCalendar {

    private List<PatientAppointment> appointments;

    public ClinicCalendar() {
        appointments=new ArrayList<>();
    }

    public void addAppointment(String patientFirstName, String patientLastName, String docKey, String dateTime){

        Doctor doc= Doctor.valueOf(docKey.toLowerCase());
        LocalDateTime localDateTime;

        try {
            localDateTime=LocalDateTime.parse(dateTime.toUpperCase(), DateTimeFormatter.ofPattern("M/d/yyyy h:mm a",Locale.US));


        }catch (Throwable t){

            throw new RuntimeException("Unable to create date time format :["+dateTime.toUpperCase()+"] , please enter with format [M/d/yyyy h:mm a]");

        }

        PatientAppointment appointment= new PatientAppointment(patientFirstName,patientLastName,localDateTime,doc);

        appointments.add(appointment);

    }

    public void setAppointments(List<PatientAppointment> appointments) {
        this.appointments = appointments;
    }

    public List<PatientAppointment> getAppointments() {
        return appointments;
    }
}

