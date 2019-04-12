package lesson12.patterns.decorator;

import lesson12.patterns.decorator.LaunchStatExt;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, FileNotFoundException {

      File statFile = new File("stat.bin");
//        LaunchStat launchStat=null;
//        if (!statFile.exists()) {//первый запуск
//            launchStat = new LaunchStat();
//        } else
//            {
//            //если не первый запуск,читаем
//
//            try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream(statFile)))
//            {
//                launchStat = (LaunchStat) obj.readObject();
//
//            } catch (IIOException | ClassNotFoundException e)
//            {
//                e.printStackTrace();
//            }
//        }
//        launchStat.update();
//        if (launchStat.isFirstLaunch()) {
//            System.out.println("Первый запуск");
//        }
//        else System.out.println("launchStat = " + launchStat);
//
//        try (ObjectOutputStream oiu = new ObjectOutputStream((new FileOutputStream(statFile))))
//        {oiu.writeObject(launchStat);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        File file = new File("stat2.bin");
        LaunchStatExt stat=null;
        if (!file.exists())
        {stat=new LaunchStatExt();
        }
        else
            try (ObjectInputStream obg = new ObjectInputStream(new FileInputStream(file))) {
                stat = (LaunchStatExt) obg.readObject();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        stat.update();
        if (stat.isFirstLaunch()) {
            System.out.println("Первый запуск");
        }
        else System.out.println("launchStat = " + stat);

        try (ObjectOutputStream oiu = new ObjectOutputStream((new FileOutputStream(statFile))))
        {oiu.writeObject(stat);}
        catch (IOException e) {
            e.printStackTrace();
        }



        ////FilterInputStream
    }
}




