package Stream;

import java.io.Serializable;
import java.util.Date;

public class Patient implements Serializable {
    private String name;
    private String secondName;
    private Date birthday;
    private boolean healthy;

    public Patient(String name, String secondName, Date birthday, boolean healthy) {
        this.name = name;
        this.secondName = secondName;
        this.birthday = birthday;
        this.healthy = healthy;
    }


    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public boolean isHealthy() {
        return healthy;
    }

}

