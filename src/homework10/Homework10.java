package homework10;





import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;


public class Homework10 {

    public static void main(String[] args) throws IOException {


        ClassLoader loader = Homework10.class.getClassLoader();
        File file = new File(loader.getResource("wp.txt").getFile());
        ///--читаем строки из файла
        ////file.toPath()- путь
        List<String> lines = Files.readAllLines(file.toPath());///для строк
        List<String> words = new ArrayList<>();////для слов
        // Читаем строки из файла

        for (String line : lines) {
            String[] wordSplit = line.toLowerCase() // приведение к нижнему регистру
                    .replaceAll("\\p{Punct}", " ") // знаки препинания на пробел
                    .trim() // убираем пробелы
                    .split("\\s");
            for (String s : wordSplit) {
                if (s.length() > 0) {
                    words.add(s.trim());
                }
            }
        }
///---------------------------------------------------------------
//        for (String word : words) {
//            System.out.println(word);
//        }

        ///------------создадим коллекция----------


        System.out.println("Сосчитать частоту встречаемости слов  " + sourchWord(words, "peace"));

        gruppword(words);

    }


////--------------------------методы-----------------
    public static int sourchWord( List<String> words, String word)
    {
        int kol=0;
        for (String w : words)
        {
         if (w.equals(word))
         {kol++;}
      }
        return kol;
    }

    public static void gruppword( List<String> words)
    {
        int kol=0;
        int dlina;
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (String w : words)
            {
           dlina=w.length();
           if (arrayList.contains(dlina)) continue;
           else
           arrayList.add(dlina);

        }
        List<String> stringList=new ArrayList<>();
        HashMap<Integer,List<String>> stringHashMap=new HashMap<>();

        for (String w : words)
        {
            dlina=w.length();
            stringList.add(w);
            stringHashMap.put(dlina,stringList);
        }



    }

}

