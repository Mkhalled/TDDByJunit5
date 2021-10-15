package com.km.patientintake;

import java.util.Scanner;

public class ClinicMain {

    private static ClinicCalendar calendar;
    public static void main(String[] args) throws Throwable {

        calendar=new ClinicCalendar();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome to the Patient Intake Computer System!\n\n");
        String lastOption="";
        while (!lastOption.equalsIgnoreCase("x")){
            lastOption=displayMenu(scanner);
        }
        System.out.println("\nExiting System ...\n");
    }

    private static String displayMenu(Scanner scanner) throws Throwable {
        System.out.println("Please select an option :");
        System.out.println("1. Enter a Patient Appointment");
        System.out.println("2. View All Appointments");
        System.out.println("X. Exit System.");
        System.out.print("Option: ");
        String option =scanner.next();
        switch (option){
            case "1": performPatientEntry(scanner);
                return option;
            case "2": performAllPatient();
                return option;
            default:
                System.out.println("Unvalid option, please re enter.");
                return option;
        }
    }

    private static void performAllPatient() {
        System.out.println("\n\nAll Appointments in System:");

        calendar.getAppointments().forEach(a-> System.out.println(a.toString()));
        System.out.println("\n Press any Key to continue ...");
    }

    private static void performPatientEntry(Scanner scanner) {
        scanner.nextLine();
        System.out.println("\n\nPlease Enter Appointment Info:");
        System.out.println("  Patient Last Name: ");
        String lastName=scanner.nextLine();
        System.out.println("  Patient First Name: ");
        String firstName= scanner.nextLine();

        System.out.println("  Appointment Date (M/d/yyyy h:m a): ");
        String when= scanner.nextLine();
        System.out.println(" Doctor last Name: ");
        String doc=scanner.nextLine();

        try {
            calendar.addAppointment(lastName,firstName,doc,when);
        }
        catch (Throwable t){
            System.out.println("Error ! "+t.getMessage());

        }
    }
}
