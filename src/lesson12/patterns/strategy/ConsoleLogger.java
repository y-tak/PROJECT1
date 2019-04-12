package lesson12.patterns.strategy;

public class ConsoleLogger implements ILogger{

    @Override
    public void write(String stoka) {
        System.out.println(" Log info = " + stoka);
    }
}
