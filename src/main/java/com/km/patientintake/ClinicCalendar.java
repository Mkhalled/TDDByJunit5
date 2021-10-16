package com.km.patientintake;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ClinicCalendar {

    private List<PatientAppointment> appointments;
    private LocalDate today;

    public ClinicCalendar(LocalDate today) {
        appointments=new ArrayList<>();
         this.today=today;
    }

    public void addAppointment(String patientFirstName, String patientLastName, String docKey, String dateTime){
        Doctor doc= Doctor.valueOf(docKey.toLowerCase());
        LocalDateTime localDateTime =  DateTimeConverter.convertStringToDateTime(dateTime, today);
        PatientAppointment appointment= new PatientAppointment(patientFirstName,patientLastName,localDateTime,doc);
        appointments.add(appointment);

    }

  /*  private LocalDateTime convertToDateTimeFromString(String dateTime) {
        LocalDateTime localDateTime;
        try {
            localDateTime=LocalDateTime.parse(dateTime.toUpperCase(), DateTimeFormatter.ofPattern("M/d/yyyy h:mm a",Locale.US));
        }catch (Throwable t){
            throw new RuntimeException("Unable to create date time format :["+ dateTime.toUpperCase()+"] , please enter with format [M/d/yyyy h:mm a]");
        }
        return localDateTime;
    }*/

    public List<PatientAppointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<PatientAppointment> appointments) {
        this.appointments = appointments;
    }

    public LocalDate getToday() {
        return today;
    }

    public List<PatientAppointment> getToDayAppointments(){
        return appointments.stream().filter(app -> app.getAppointmentDateTime().toLocalDate().equals(today)).collect(Collectors.toList());
    }

    public boolean hasAppointment(LocalDate date){
        return appointments.stream().anyMatch(app-> app.getAppointmentDateTime().toLocalDate().equals(date));
    }
}

