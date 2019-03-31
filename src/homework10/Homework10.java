package homework10;

///import lesson9.collect.collecr.CollectionExample;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;



public class Homework10 {

    public static void main(String[] args) throws IOException {


        ClassLoader loader = Homework10.class.getClassLoader();
        File file = new File(loader.getResource("wp.txt").getFile());
        ///--читаем строки из файла
        ////file.toPath()- путь
        List<String> lines = Files.readAllLines(file.toPath());///для строк
        List<String> words = new ArrayList<>();////для слов

       for (String line : lines)
        {  String[] wordsSplit = line.toLowerCase()/// к нижнему регистру
               .replaceAll("\\p{Punct}", " ")      ///знаки препинаняи на пробел
               .trim() //убрали проблемы с начала и конца
               .split("\\s"); //разбиваем на слова

           for (String s: wordsSplit)
           {
              if(s.length()==0) words.add(s.trim());
           }

           for (String word:words)
           {
               System.out.println("word = " + word);
           }
        }

    }
}
