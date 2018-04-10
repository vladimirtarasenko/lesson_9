package Stream;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputConsolePatient implements PatienInput {
    private Scanner scanner = new Scanner(System.in);
    HashSet<Patient> patientSet = new HashSet<>();

    Patient patient;

    @Override
    public HashSet<Patient> addPatient() throws DoublePatientException {
        scanner.nextLine();
        System.out.println("Please enter the patient's name :");
        String name = scanner.nextLine();
        System.out.println("Please enter the patient's surname :");
        String secondName = scanner.nextLine();
        System.out.println("Please enter the patient's birhday(in YYYY-MM-DD format :");
        Date birthday = birthday(scanner.nextLine());
        System.out.println("Please enter is the patient ill(true/false) :");
        boolean isHealthy = scanner.nextBoolean();
        patient = new Patient(name, secondName, birthday, isHealthy);

        for (Patient p : patientSet) {
            try {
                if (p.getName().equals(name) && p.getSecondName().equals(secondName) && p.getBirthday().equals(birthday))
                    throw new DoublePatientException("This patient already in the list !");
            } catch (DoublePatientException e) {
                System.out.println(" This patient already in the list ! If you want to change his health status please repeat the enter.");
                patientSet.remove(p);
                return addPatient();
            }
        }
        patientSet.add(patient);
        return patientSet;
    }

    public Date birthday(String birthday) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(birthday);
        } catch (ParseException e) {
            System.out.println("Неверная дата рождения,введите снова");
            return birthday(scanner.nextLine());
        }
    }
}

