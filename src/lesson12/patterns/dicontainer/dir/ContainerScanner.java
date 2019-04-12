package lesson12.patterns.dicontainer.dir;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class ContainerScanner {

    private static final char PACKEGE_SEP='.';///констранты
    private static final char DIR_SEP='/';



    public static ArrayList<Class> scan(String packageName) throws ClassNotFoundException {
        String scannedPath=packageName.replace(PACKEGE_SEP,DIR_SEP);
        ////сканируем имена пакетов
        URL scannerUrl=Thread.currentThread().getContextClassLoader().getResource(scannedPath);

       if(scannerUrl==null){throw new IllegalArgumentException("Wrong Argument");}

             ///нашли папку и сканируем и помещаем в массив
            File scannedDir=new File(scannerUrl.getFile());
            ArrayList<Class> classes=new ArrayList<>();

            for (File file:scannedDir.listFiles())///список файлов и директорий
            {
                classes.addAll(scan(file,packageName));
            }
            return classes;


    }

    private static ArrayList<Class> scan(File file,String packageName) throws ClassNotFoundException
    {
        ArrayList<Class> classes=new ArrayList<>();
        String resorse=packageName+PACKEGE_SEP+file.getName();

        if (file.isDirectory())
        {
            for (File file1:file.listFiles() )
            {
                classes.addAll(scan(file1,packageName));
            }
        }
        ///--Someclass.class
        else if(resorse.endsWith(".class"))
        {
           int lastIndex=resorse.lastIndexOf(PACKEGE_SEP);
           String className=resorse.substring(0,lastIndex);
           classes.add(Class.forName(className));

        }
        return classes;
    }



}
