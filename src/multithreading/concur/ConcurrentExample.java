package multithreading.concur;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;


public class ConcurrentExample {

    ///потокобезопасные коллекции
    ///блокирующие и неблокирующие очереди
    //пул потоков
    ///альтернативы wait()  и  notify() и synchronize()


    public static void main(String[] args) {
        ///CopyOnWriteArrayList вместо ArrayList


        LinkedBlockingQueue queue;
        LinkedBlockingDeque deque;

        LinkedTransferQueue transferQueue;
        PriorityBlockingQueue priorityBlockingQueue;
        ///нельзя менять размер
        ArrayBlockingQueue arrayBlockingQueue=new ArrayBlockingQueue(4,true);

        SynchronousQueue synchronousQueue;             //очередь на один элемент





       /// CopyOnWriteArraySet
        ConcurrentNavigableMap<String,Integer> map;
        ConcurrentSkipListMap<String,Integer> rr = null;
        rr.putIfAbsent("qwe",2);//аналоги TreeMap
        rr.remove("qwe",2);//удаляет  TreeMap
        rr.replace("qwe",2,5);//Заменить значения TreeMap
        ConcurrentSkipListSet<String> set;

        CopyOnWriteArrayList<String> list1 = new CopyOnWriteArrayList<>();
        List<String> list = new CopyOnWriteArrayList<>();
        // List<String> list = new ArrayList<>();
        list.add("qwe");
        list.add("sdf");
        list.add("rew");
        list.add("tyu");
        list.add("jhg");
        list1.add("fgh");
        list1.addIfAbsent("dfs");///не добавляет  дубли..
        new WriteThread(list).start();
        new ReadThread(list).start();


    }
}

class WriteThread extends Thread {
    private List<String> list;
    private ArrayList<String> data=new ArrayList<>();
    ///private ArrayList<String> data=new CopyOnWriteArrayList<>();

    public WriteThread(List<String> list)
    {
        this.list = list;
        data.add("uyi");
        data.add("iuy");
        data.add("ooo");
        data.add("tyu");
        data.add("poi");
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {

            if (i == data.size() - 1) i=0;
        else
            {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add(data.get(i));
                i++;
                System.out.println("WriteThread add "+data.get(i));

            }
        }
    }
}


class ReadThread extends Thread
{
    private List<String> list;

    public ReadThread(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
      while (true)
      { String res="ReadThread res:";

//      for (String  str:list)
//      {res+=str+" ";
//             try {
//                 Thread.sleep(500);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//      }


          for (String str : list) {
              if (list.contains("sdf"))
                  list.remove(str);
              res+=str+" ";
              try {
                  Thread.sleep(500);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }


//          Iterator<String> iterator = list.iterator();
//          while (iterator.hasNext())
//          {
//              String next=iterator.next();
//              res+=next+" ";
//              try {
//                  Thread.sleep(500);
//              } catch (InterruptedException e) {
//                  e.printStackTrace();
//              }
//          }

          System.out.println(" res " +  res);

      }
    }
}