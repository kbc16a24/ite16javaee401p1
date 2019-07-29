package beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Blood implements Serializable {

    @Id
    @NotNull
    private String name;
    private String pass;
    
    public Blood() {
    }

    public Blood(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public Blood(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
