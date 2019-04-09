package lesson13.container;

import lesson13.annotation.Exclude;

public class Someclass {


    SomeClassConfig config;

    public Someclass()
    {
    }

    public SomeClassConfig getConfig() {
        return config;
    }

    public void setConfig(SomeClassConfig config) {
        this.config = config;
    }


    @Override
    public String toString() {
        return "Someclass{" +
                "config=" + config +
                '}';
    }
}
