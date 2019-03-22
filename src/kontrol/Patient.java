package kontrol;

public class Patient extends User implements UserIter{

    public Patient(String password) {
        super(password);
        this.setName("Василий");
    }

    public Patient(String name, String password) {
        super(name, password);
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
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public void write() {

    }

    @Override
    public void exit() {

    }

}
