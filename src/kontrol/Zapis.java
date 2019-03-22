package kontrol;

import java.util.Date;

public class Zapis {
    private Doctor doctor;
    private Patient patient;
    private String date; ///хотела Date date перепишу потом
    private String number;
    private boolean activ;
    public Zapis() {
    }


    public Zapis(Doctor doctor, Patient patient, String date,String n) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.number = n;

    }

    public boolean isActiv() {
        return activ;
    }

    public void setActiv(boolean activ) {
        this.activ = activ;
    }

    @Override
    public String toString() {
        return "Zapis{" +
                "N"+number+
                "doctor=" + doctor +
                ", patient=" + patient +
                ", date=" + date +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
