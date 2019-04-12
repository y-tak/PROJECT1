package fitness;

public class Human {
    private String soname;
    private String name;
    private int dataYear;
    private String dataReg;

    public Human(String soname, String name, int dataYear) {

        this.soname = soname;
        this.name = name;
        this.dataReg = "12.04.2019";
        this.dataYear = dataYear;;
    }

    public Human(String soname, String name, int dataYear, String dataReg)
    {
        this.soname = soname;
        this.name = name;
        this.dataYear = dataYear;
        this.dataReg = dataReg;
    }

    public String getSoname() {
        return soname;
    }

    public void setSoname(String soname) {
        this.soname = soname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDataYear() {
        return dataYear;
    }

    public void setDataYear(int dataYear) {
        this.dataYear = dataYear;
    }

    public String getDataReg() {
        return dataReg;
    }

    public void setDataReg(String dataReg) {
        this.dataReg = dataReg;
    }

    @Override
    public String toString() {
        return "Human{" +
                "soname='" + soname + '\'' +
                ", name='" + name + '\'' +
                ", dataYear=" + dataYear +
                ", dataReg='" + dataReg + '\'' +
                '}';
    }
}
