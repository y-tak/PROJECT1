package homework13;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class MapHomework {

    public static void main(String[] args) throws IOException {
        ClassLoader loader =MapHomework.class.getClassLoader();

        File file = new File(loader.getResource("wp.txt").getFile());

        // Читаем строки из файла
        List<String> lines = Files.readAllLines(file.toPath());

        List<String> words = new ArrayList<>();

        for (String line : lines) {
            String[] wordMap = line.toLowerCase() // приведение к нижнему регистру
                    .replaceAll("\\p{Punct}", " ") // знаки препинания на пробел
                    .trim() // убираем пробелы
                    .split("\\s");
            for (String s : wordMap) {
                if (s.length() > 0) {
                    words.add(s.trim());

                }
            }
        }

        HashMap<Integer, HashSet<String>> groupMap =new HashMap<>();
        for (String word:words)
        { int len=word.length();
        if (!groupMap.containsKey(len))
        {groupMap.put(len,new HashSet<>());
        }
            groupMap.get(len).add(word);
        }




    }
}
