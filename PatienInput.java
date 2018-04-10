package Stream;

import java.util.Set;

public interface PatienInput {
    Set addPatient() throws DoublePatientException;
}
