package ui;

import model.Doctor;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {

    public static void showPatientMenu(){
        int response = 0 ;
        do{
            System.out.println("\n\nPatien");
            System.out.println("WELCOME " + UIMenu.patientLogged.getName());
            System.out.println("1. BOOK AN APPOINTMENT");
            System.out.println("2. MY APPOINTMENTS");
            System.out.println("0. LOGOUT");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        }while(response!=0);
    }

    private static void showBookAppointmentMenu(){
        int response = 0;
        do{
            System.out.println(":: BOOK AN APPOINTMENT");
            System.out.println(":: SELECT DATE: ");
            //NUMERACIÓN DE LA LISTA DE FECHAS
                            //INDICE DE LA FECHA SELECCIONADA
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments
                        = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();
                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();

                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". " + availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }
            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("","");

            for (Map.Entry<Integer, Doctor> doc :doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getName() +
                    " DATE: " + doctorSelected.getAvailableAppointments().get(indexDate).getDate() +
                    " TIME: " + doctorSelected.getAvailableAppointments().get(indexDate).getTime());
            System.out.println("CONFIRM YOUR APPOINTMENT: \n1. YES  \n2. CHANGE DATA");
            response = Integer.valueOf(sc.nextLine());

            if (response == 1){
                UIMenu.patientLogged.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());
                showPatientMenu();
            }

        }while(response!=0);
    }

    private static void showPatientMyAppointments(){
        int response = 0;
        do{
            System.out.println("::MY APPOINTMENTS");
            if (UIMenu.patientLogged.getAppointmentDoctors().size() == 0){
                System.out.println("NO APPOINTMENTS");
                break;
            }
            for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". " +
                        "DATE: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() +
                        "TIME: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime() +
                        "\nDOCTOR: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName());
            }

            System.out.println("0. RETURN");
        }while(response!=0);
    }
}
