package fitness;

public class Access
{
    private int vremyOn;
    private int vremyOf;
    FitnessServiceEnumeration type;

    public Access(int vremyOn, int vremyOf, FitnessServiceEnumeration type)
    {
        this.vremyOn = vremyOn;
        this.vremyOf = vremyOf;
        this.type = type;
    }

    public int getVremyOn() {
        return vremyOn;
    }

    public void setVremyOn(int vremyOn) {
        this.vremyOn = vremyOn;
    }

    public int getVremyOf() {
        return vremyOf;
    }

    public void setVremyOf(int vremyOf) {
        this.vremyOf = vremyOf;
    }

    public FitnessServiceEnumeration getType() {
        return type;
    }

    public void setType(FitnessServiceEnumeration type) {
        this.type = type;
    }


}
