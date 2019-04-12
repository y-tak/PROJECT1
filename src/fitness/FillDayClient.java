package fitness;

@AccessMode
public class FillDayClient extends Human {
//    private Access group=new Access(8,22,FitnessServiceEnumeration.GROUP);
//    private Access gym=new Access(8,22,FitnessServiceEnumeration.GYM);
//    private Access pool=new Access(8,22,FitnessServiceEnumeration.POOL);

    public FillDayClient(String soname, String name, int dataYear) {
        super(soname, name, dataYear);
    }

    public FillDayClient(String soname, String name, int dataYear, String dataReg) {
        super(soname, name, dataYear, dataReg);
    }


}
