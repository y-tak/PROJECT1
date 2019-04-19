package multithreading;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Top100 {

    ////------------------------------------------------------------------
    public static void main(String[] args) throws IOException, InterruptedException {
        ///выполнить подсчет 100 популярных слов

        Runtime.getRuntime().availableProcessors();///количетсве процессов
        HashMap<String, Integer> allhashMap = new HashMap<>();
        //считываем коллекцию - основной потое
        // каждый потомк считает слова и возвращает в общую MAP
        // складывает в общий..
        /// Основной ждет выполнение всех потоков и только пото мзавершиться
        //общий ресурс MAP


        ClassLoader loader = Top100.class.getClassLoader();
        File file = new File(loader.getResource("wp.txt").getFile());
        ///--читаем строки из файла
        ////file.toPath()- путь
        List<String> lines = Files.readAllLines(file.toPath());///для строк
        ArrayList<String> words = new ArrayList<>();////для слов
        // Читаем строки из файла

        for (String line : lines) {
            String[] wordSplit = line.toLowerCase() // приведение к нижнему регистру
                    .replaceAll("\\p{Punct}", " ")
                    .replaceAll("\\p{Digit}", " ")// знаки препинания на пробел
                    .trim() // убираем пробелы
                    .split("\\s");
            for (String s : wordSplit) {
                if (s.length() > 0) {
                    words.add(s.trim());
                }
            }
        }
         ArrayList<Thread> threads=new ArrayList<>();
        ArrayList list = new ArrayList();
        int n = Runtime.getRuntime().availableProcessors();
        int sizew = words.size();
        for (int i = 0; i < n - 1; i++) {
            List list1 = words.subList(((sizew * i / n) + 1), sizew * (i + 1) / n);
            MyThread myThread = new MyThread(list1);
            myThread.setAllhashMap(allhashMap);
            Thread thr1 = new Thread(myThread);
            thr1.start();
            threads.add(thr1);

        }

        for (Thread tr:threads)
        {tr.join();}


        System.out.println("завершение всех потоков");

///-----------------основной поток
       // System.out.println("allhashMap= " + allhashMap.entrySet());

        List listAll = new ArrayList(allhashMap.entrySet());
        Collections.sort(listAll, new Comparator<Map.Entry<String, Integer>>()
        {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
            {
                return o1.getValue()-o2.getValue();
            }
        });
      //  System.out.println("listAll = " + listAll);

        for (int i=listAll.size()-1;i>listAll.size()-11;i--)
        {
            System.out.println("лист по порядку " + listAll.get(i));
        }

      }
}

  class MyThread implements Runnable {

        List list;
        HashMap<String, Integer> allhashMap = new HashMap<>();

      @Override
      public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;

          MyThread myThread = (MyThread) o;

          if (list != null ? !list.equals(myThread.list) : myThread.list != null) return false;
          return allhashMap != null ? allhashMap.equals(myThread.allhashMap) : myThread.allhashMap == null;
      }

      @Override
      public int hashCode() {
          int result = list != null ? list.hashCode() : 0;
          result = 31 * result + (allhashMap != null ? allhashMap.hashCode() : 0);
          return result;
      }

      public MyThread(List list)
        {
            this.list = list;
            System.out.println(" поток запущен " );

        }

      public void setAllhashMap(HashMap<String, Integer> allhashMap) {
          this.allhashMap = allhashMap;
      }



      @Override
        public void run() {
            putW();

        }

        private synchronized void putW() {

            popularWord(list);

        }


        public  void popularWord(List<String> words) {
            List<String> stringList = new ArrayList<>();
            HashMap<String, Integer> hashMap = new HashMap<>();

            for (String w : words) {
                if (stringList.contains(w)) continue;
                else
                    stringList.add(w);
            }

            for (String f : stringList) {
                int kol = 0;
                for (String w : words) {
                    if (f.equals(w)) kol++;
                }
                hashMap.put(f, kol);
            }


            System.out.println("поток отработал ");
            ///добавляет в общую Map

            synchronized (allhashMap)
            {
                Iterator<Map.Entry<String,Integer>> iterator= hashMap.entrySet().iterator();
                ////----удаление во время итерации---
                while (iterator.hasNext())
                {
                    Map.Entry<String,Integer> entry=iterator.next();
                    String name =entry.getKey();
                    int kol =entry.getValue();
                  if (allhashMap.containsKey(name)) allhashMap.put(name,kol++);
                    else allhashMap.put(name,kol);
                }

            }

            System.out.println("записал в общую ");
        }
    }


