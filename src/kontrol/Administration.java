package kontrol;

import lesson4.Unit;

public class Administration extends User implements UserIter{
    public Administration(String name, String password) {
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
