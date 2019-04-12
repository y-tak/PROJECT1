package fitness;

@AccessMode(group = "16",gym = "16",pool = "0")
public class DayClient extends Human {

    private String dateOfReg;
//    private Access group=new Access(8,16,FitnessServiceEnumeration.GROUP);
//    private Access gym=new Access(8,16,FitnessServiceEnumeration.GYM);
//

    public DayClient(String soname, String name, int dataYear) {
        super(soname, name, dataYear);
        ///---TODO время нормально считать
        this.dateOfReg=getDataReg().replace("2019","2020");

    }

    public DayClient(String soname, String name, int dataYear, String dataReg, int kolMounf) {
        super(soname, name, dataYear, dataReg);
        ///---TODO время нормально считать
        this.dateOfReg = "12.06.2019";//kolMounf=2
    }
}
