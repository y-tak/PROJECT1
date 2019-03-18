package lesson4;

public class Unit {
    protected   int health;//использование в дочернем классе

    public Unit(int health) {
        this.health = health;
    }

    public boolean isAlive()
    {
        return health>0;
    }
}
