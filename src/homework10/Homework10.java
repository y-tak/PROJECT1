package homework10;





import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;


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

        System.out.println("--задача1---");
        System.out.println("Сосчитать частоту встречаемости слов  " + sourchWord(words, "peace"));
        System.out.println("--задача2---");
        gruppword(words);
        System.out.println("--задача3---");
        popularWord(words);
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
    ///----------------------------------------------

    public static void gruppword( List<String> words) {
        int kol = 0;
        int dlina;
        int a=1;
        int maxDl=0;
      for (String w : words)
      {
           dlina = w.length();
           maxDl=Integer.max(a,dlina);
          a=maxDl;
          
       }
        System.out.println("maxDl = " + maxDl);
        HashMap<Integer, List<String>> stringHashMap = new HashMap<>();
        for (int i=0;i<maxDl;i++)
        {
            List<String> stringList = new ArrayList<>();
            for (String w : words)
            {
                if (i==w.length())
                {
                stringList.add(w);
                }
                else continue;
            }
            stringHashMap.put(i, stringList);
        }

///----------вывод на экран-------------
        for (int i=0;i<maxDl;i++) {

            System.out.println("длина = "+i+"  лист" + stringHashMap.get(i));

        }
    }
    ///------------------конец метода------------------

    public static void popularWord(List<String> words)
    {
        List<String> stringList = new ArrayList<>();
        HashMap<String, Integer> stringHashMapP = new HashMap<>();
        for (String w:words)
        {
            if (stringList.contains(w)) continue;
            else
            stringList.add(w);
        }

        for (String f:stringList)
        {
            int kol=0;
            for (String w:words)
            {
                if (f.equals(w)) kol++;
            }
            stringHashMapP.put(f,kol);
        }

        List list = new ArrayList(stringHashMapP.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
                {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
                    {
                        return o1.getValue()-o2.getValue();
                    }
                });


        stringHashMapP.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);


    }
    
    
}

