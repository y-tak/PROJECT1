package fitness;
import java.io.*;

public class FitnessLogger {
    Human human;
    StringBuilder sb = new StringBuilder();

    public void addName(Human human)
    {
        sb.append(human.getSoname()).append(" ").append(human.getName()).append(" ").append(" 12:00").append(" ;");
        File file= new File("src/log.txt");


        try (FileOutputStream fileOutputStream = new FileOutputStream(file))

        {
            {
               byte[] buffer = sb.toString().getBytes();
               fileOutputStream.write(buffer, 0, buffer.length);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("rec in file log.txt" );

    }

}
