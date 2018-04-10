package Stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileInOut {

    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("base1.date"));

    public FileInOut() throws IOException {
    }
}
