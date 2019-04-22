package multithreading.pool;

import java.util.concurrent.*;

public class FutureTaskExample {
    public static void main(String[] args) {

        Callable<UserInfo> callable = new CreateUserTask(2000);
        Callable<UserInfo>callable1= new CreateUserTask(5000);

        FutureTask<UserInfo> futureTask=new FutureTask<>(callable);
        FutureTask<UserInfo> futureTask1=new FutureTask<>(callable1);

        ExecutorService service= Executors.newFixedThreadPool(2);
        service.execute(futureTask);  ///создаем объект и запаускаем ее, выполняет не возвращая
        service.execute(futureTask1);


        while (true)
        {
            if (futureTask.isDone()&&futureTask1.isDone())
            {
                System.out.println("задачи завершены");
                service.shutdown();///закрывает все задачи и завершает работу потоков
                return;
            }
            if (futureTask.isDone()){
                try {
                    System.out.println("futureTask result " + futureTask.get());
                } catch (InterruptedException|ExecutionException e) {
                    e.printStackTrace();
                }
            }
            if (futureTask1.isDone() ){
                try {
                    System.out.println("futureTask1 result " + futureTask.get());
                } catch (InterruptedException|ExecutionException e) {
                    e.printStackTrace();
                }
            }


            System.out.println("ожидание завершения futureTask1" );

            try {
                UserInfo userInf= null;
                userInf = futureTask1.get(200L, TimeUnit.SECONDS);
                if (userInf!=null) System.out.println("futureTask1 result = " + userInf);
            } catch (InterruptedException |ExecutionException|TimeoutException e) {
                e.printStackTrace();
            }

        }

    }
}

class UserInfo
{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                '}';
    }
}
class CreateUserTask implements Callable<UserInfo>
{
 long sleepTime;

    public CreateUserTask(long sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public UserInfo call() throws Exception {
        Thread.sleep(sleepTime);
        UserInfo userInfo =new UserInfo();
        userInfo.setName(Thread.currentThread().getName());
        return userInfo;

    }
}