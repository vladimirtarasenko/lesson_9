package Stream;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_Stream {
    public static void main(String[] args) throws IOException, DoublePatientException {
        Scanner scanner = new Scanner(System.in);
        Set<Patient> patientOne = new HashSet<>();
        PatienInput patienInput = new InputConsolePatient();
        GetRemotePatients remotePatients = new GetRemotePatients();
        OutputLocalPatients localPatients = new OutputLocalPatients();
        StartUpMenu menu = new StartUpMenu();

        do {
            switch (menu.startMenu()) {
                case 1:
                    remotePatients.addRemote();
                    break;
                case 2:
                    do {
                        patientOne = patienInput.addPatient();
                        scanner.nextLine();
                        System.out.println("Do you want to add one more patient (enter 'y' or 'n') ? ");
                    } while (scanner.nextLine().equals("y"));

                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("base1.date"))) {
                        oos.writeObject(patientOne);
                        oos.flush();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 3:
                    localPatients.getLocalPatientsInfo();
                    break;
            }
            System.out.println("Do you want to contitnue the work with patients list (press 'y' or 'n') ? ");
        } while (scanner.nextLine().equals("y"));
        System.out.println("See you next time !");
    }
}
