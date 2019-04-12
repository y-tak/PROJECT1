package fitness;


@AccessMode(group = "0")
public class Client extends Human {

    private boolean visit=false;
//    private Access gym=new Access(8,22,FitnessServiceEnumeration.GYM);
//    private Access pool=new Access(8,22,FitnessServiceEnumeration.POOL);

    public Client(String soname, String name, int dataYear) {
        super(soname, name, dataYear);
    }

    public Client(String soname, String name, int dataYear, String dataReg) {
        super(soname, name, dataYear, dataReg);
    }

    ///----------------------------------
    public boolean isVisit() {
        return visit;
    }

    public void setVisit(boolean visit) {
        this.visit = visit;
    }

}
