package lesson12.patterns.strategy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements ILogger
{
    @Override
    public void write(String stoka) {

        try(BufferedWriter writer=new BufferedWriter(new FileWriter("log.txt",true)))
        {
            writer.write("Log info "+stoka);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
