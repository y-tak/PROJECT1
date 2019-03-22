package kontrol;

public class Doctor extends User implements UserIter {
    private String spez;

    public Doctor(String name, String password)
    {
        super(name, password);

    }

    public Doctor(String password) {
        super(password);
    }

    public Doctor(String name, String password, String spez) {
        super(name, password);
        this.spez = spez;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void write()
    {
    }

    @Override
    public void exit() {

    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);

    }
}
