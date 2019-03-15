package com.companyName.lessons;

public class Izdatel {
    private String family;
    private String name;

    public String getFamily() {
        return family;
    }

    public Izdatel(String family, String name) {
        this.family = family;
        this.name = name;
    }
    public Izdatel() {
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " " + family + '\''+
                " "+ name + '\'' +
                '}';
    }
}
