package Stream;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Set;

public class GetRemotePatients implements PatientAddRemote {

    URL myUrl = new URL("https://raw.githubusercontent.com/vladimirtarasenko/lesson_3/dev/Patients.txt");
    InputConsolePatient bd = new InputConsolePatient();
    Set<Patient> patientSet = new HashSet<>();
    HttpURLConnection myUrlCon = (HttpURLConnection) myUrl.openConnection();

    public GetRemotePatients() throws IOException {
    }

    public void addRemote() throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(myUrl.openStream()));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("base1.date"));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            String[] strings = inputLine.split(";");
            Patient patient = new Patient(strings[0], strings[1], bd.birthday(strings[2]), Boolean.valueOf(strings[3]));
            patientSet.add(patient);
            oos.writeObject(patientSet);
            oos.flush();
        }
        in.close();
    }

}

