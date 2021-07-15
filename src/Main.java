import model.*;

import java.util.Date;

import static ui.UIMenu.*;

public class Main {
    public static void main(String[] args) {

        showMenu();
        /*Doctor myDoctor = new Doctor("Blanca Briceño", "b.briceño@gmail.com");
        myDoctor.addAvailableAppointment(String.valueOf(new Date()), "4pm");
        myDoctor.addAvailableAppointment(String.valueOf(new Date()), "10am");
        myDoctor.addAvailableAppointment(String.valueOf(new Date()), "1pm");

        System.out.println(myDoctor);

        User user = new Doctor("ANAHI", "ANA@GMAIL.COM");
        user.showDataUser();

        User userPa = new Patient("ANAHI", "ANA@GMAIL.COM");
        userPa.showDataUser();

        User user1 = new User("PALOMA", "PALOMA@GMAIL.COM") {
            @Override
            public void showDataUser() {
                System.out.println("\n\n\nDOCTOR\n");
                System.out.println("HOSPITAL: CRUZ NARANJA");
                System.out.println("DEPARTAMENTO: GERIATRÍA");
            }
        };

        user1.showDataUser();

        ISchedulable iSchedulable = new ISchedulable() {
            @Override
            public void schedule(Date date, String time) {

            }
        };

        for (model.Doctor.AvailableAppointment aA:myDoctor.getAvailableAppointments()) {
            System.out.println(aA.getDate() + " " + aA.getTime());
        }

        System.out.println();
        System.out.println();
        Patient patient = new Patient("Cristian", "cristian@mail.com");
        System.out.println(patient);*/
    }
}
