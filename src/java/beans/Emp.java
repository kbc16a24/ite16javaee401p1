package beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Emp implements Serializable {

    @Id
    private Integer bldup;
    private Integer blddn;
    private Integer rate;
    private Date date;
    private String time;
    private String state;

    public Emp() {
    }

    public Emp(Integer bldup, Integer blddn, Integer rate, Date date, String time, String state) {
        this.bldup = bldup;
        this.blddn = blddn;
        this.rate = rate;
        this.date = date;
        this.time = time;
        this.state = state;
    }

    public Integer getBldup() {
        return bldup;
    }

    public void setBldup(Integer bldup) {
        this.bldup = bldup;
    }

    public Integer getBlddn() {
        return blddn;
    }

    public void setBlddn(Integer blddn) {
        this.blddn = blddn;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
}
