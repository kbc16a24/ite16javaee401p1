package beans;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped

public class Bb implements Serializable {
    
    private String name;
    private String pass;
    private Integer bldup;
    private Integer blddn;
    private Integer rate;
    private Date date;
    private String time;
    private static Map<String, String> timeitems;
    static {
        timeitems = new LinkedHashMap<>();
        timeitems.put("1:00", "1:00");
        timeitems.put("2:00", "2:00");
        timeitems.put("3:00", "3:00");
        timeitems.put("4:00", "4:00");
        timeitems.put("5:00", "5:00");
        timeitems.put("6:00", "6:00");
        timeitems.put("7:00", "7:00");
        timeitems.put("8:00", "8:00");
        timeitems.put("9:00", "9:00");
        timeitems.put("10:00", "10:00");
        timeitems.put("11:00", "11:00");
        timeitems.put("12:00", "12:00");
        timeitems.put("13:00", "13:00");
        timeitems.put("14:00", "14:00");
        timeitems.put("15:00", "15:00");
        timeitems.put("16:00", "16:00");
        timeitems.put("17:00", "17:00");
        timeitems.put("18:00", "18:00");
        timeitems.put("19:00", "19:00");
        timeitems.put("20:00", "20:00");
        timeitems.put("21:00", "21:00");
        timeitems.put("22:00", "22:00");
        timeitems.put("23:00", "23:00");
        timeitems.put("24:00", "24:00");
    }

    private String state;
    private static Map<String, String> items;
    
    static {
        items = new LinkedHashMap<>();
        items.put("朝食後","朝食後");
        items.put("起床後","起床後");
        items.put("入浴後","入浴後");
        items.put("その他","その他");
    }
    
    @EJB
    EmpDb db;
    @EJB
    BloodDb bdb;
    @Inject
    transient Logger log;

    public String create() {
        Blood blood = new Blood(name, pass);
        try {
            bdb.create(blood);
            clear();
        } catch (Exception e) {
            log.fine(e.getMessage());
        }
        return "/update.xhtml?faces-redirect=true";
    }

    public String edit(Emp emp) {
        bldup = emp.getBldup();
        blddn = emp.getBlddn();
        rate = emp.getRate();
        date = emp.getDate();
        time = emp.getTime();
        state = emp.getState();
        return null;
    }

    public String update() {
        Emp emp = new Emp(bldup, blddn, rate, date, time, state);
        try {
            db.update(emp);
            clear();
        } catch (Exception e) {
            log.fine(e.getMessage());
        }
        return null;
    }

    public String delete(Emp emp) {
        db.delete(emp);
        return null;
    }

    public String find() {	
        Blood m = bdb.find(name);
        if (m != null) {
            this.name = m.getName();
            this.pass = m.getPass();
        }else{
            clear();
            return null;
        }
        return "/update.xhtml?faces-redirect=true";
    }

    public List<Emp> getAll() {
        return db.getAll();
    }

    public void clear() {
        name = null;
        pass = null;
        state = null;
        bldup = null;
        blddn = null;
        rate = null;
        date = null;
        time = null;
    }
    
    public void csv() {
        try {
            File csv = new File("sample.csv");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(csv,true))) {
                bw.write(getState() + ',' + getBldup() + ',' + getBlddn() + ',' + getRate() + ',' + getDate() + ',' + getTime());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
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
    
    public Map<String, String> getItems() {
        return items;
    }
    
    public Map<String, String> getTimeitems() {
        return timeitems;
    }

}
