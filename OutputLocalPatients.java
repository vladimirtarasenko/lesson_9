package Stream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Set;

public class OutputLocalPatients {

    public void getLocalPatientsInfo() {
        Set<Patient> newPatient = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("base1.date"))) {
            newPatient = (Set<Patient>) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        for (Patient p : newPatient) {
            System.out.print("Name: " + p.getName() + " ");
            System.out.print("Second name: " + p.getSecondName() + " ");
            System.out.printf("%1$s %2$td %2$tB %2$tY", "Birthday: ", p.getBirthday());
            System.out.println(" Is healthy: " + p.isHealthy() + " ");
        }
    }
}
