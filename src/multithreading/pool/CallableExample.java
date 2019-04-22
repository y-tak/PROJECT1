package multithreading.pool;

import java.util.ArrayList;
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) {

        ExecutorService executorService= Executors.newFixedThreadPool(10); //очередь из 10 потоков

        Callable<Article> articleCallable=new ThreadTask();
        ArrayList<Future<Article>> list =new ArrayList<>();/// когда потоки выполянт то вернуться объект Future


        for (int i=0;i<15;i++)
        {
            Future<Article> articleFuture=executorService.submit(articleCallable);// связали пул потоков и задачи
           list.add(articleFuture);
           // System.out.println("articleFuture isDone() = " + articleFuture.isDone());
          //  System.out.println("articleFuture isCancelled() = " + articleFuture.isCancelled());
            ////выполняет задачу и отправляет
        }

        for (Future<Article> kl:list)
        {
            try {
                System.out.println("result = " + kl.get());
            } catch (InterruptedException |ExecutionException e) {
                e.printStackTrace();
            }

        }

    }
}


class Article
{
    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                '}';
    }
}
class ThreadTask implements Callable<Article> ///вернуть из потока значение
{

    @Override
    public Article call() throws Exception { ///ThreadTask
        Thread.sleep(500);
        Article article=new Article();
        article.setTitle(Thread.currentThread().getName());//название статьи- имся потока который ее создал
        return article;
    }
}