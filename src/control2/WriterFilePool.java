package control2;

import java.io.*;
import java.util.concurrent.*;

public class WriterFilePool {


    public static void main(String[] args) {
         ExecutorService fixedPool = Executors.newFixedThreadPool(4);

    fixedPool.execute(new WriterR("lko"));
    fixedPool.execute(new WriterR("aaa"));
    fixedPool.execute(new WriterR("sdf"));
    fixedPool.execute(new WriterR("rty"));
    fixedPool.execute(new WriterR("ert"));

        fixedPool.shutdown();

    }
}


class WriterR implements Runnable {

            private String word;

            public WriterR(String fin) {
                this.word = fin;

            }



    public synchronized void writeTo()
            {
                   if (Thread.currentThread().isAlive()) {
                       try {

                           FileWriter filelog=new FileWriter(new File("src/file_control.txt"),true);
                           //запись в файл
                           filelog.write(word+"\n");
                           filelog.flush();

                       } catch (IOException e) {
                           e.printStackTrace();


                       }

                   }
            }


            @Override
            public void run() {
              
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    writeTo();
                    
                    System.out.println("word+  в потоке = " + word + " " + Thread.currentThread().getName());
                 

               

            }
        }
