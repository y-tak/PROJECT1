package lesson4;

public class BattelUnit extends Unit{
    private int attackScore;

    public BattelUnit(int health, int attackScore) {
        super(health);
        this.attackScore = attackScore;//новые свойства
    }

    public void attack(BattelUnit enemy)
    { if (!this.isAlive())
    {System.out.println("персонаж мертв");return;}
else System.out.println("персонаж жив");
        enemy.health-=this.attackScore;  // enemy.health=enemy.health-this.attackScore;
    }

}
