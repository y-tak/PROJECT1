package lesson4;
///класс наследуется от BattelUnit
public class Knight extends  BattelUnit{

    public Knight(int health, int attackScore)
    {
        ///вызов конструктора родительского класса
        super(health, attackScore);
    }


    ////переопределение метода родителя
   @Override
    public void attack(BattelUnit enemy)
    {
   ///---вызов родительского метода
        /*super.attack(enemy);
        //расщирение функционала
        enemy.health-=1;*/
        enemy.health-=10;


    }



}
