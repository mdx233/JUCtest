import javax.sql.rowset.CachedRowSet;
import java.util.concurrent.*;

/**
 *功能描述
 * @author mdx
 * @date 2020/8/17
 * @param
 * @return
 * Callable接口
 *
 * Callable接口相较于Runnable接口
 * 不同：
 *      1.Callable接口实现方法为call(),Runnable接口实现方法为run()
 *      2.call()方法可以有返回值，Callable<>泛型为什么，call()方法返回值就为什么，run()方法返回值为空。
 *      3.call()方法可以抛出异常，run()方法不能抛出异常。
 *
 *1     get方法一般请放在最后一行
 */
class MyThread1 implements Runnable{

    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("芜湖！起飞");
        TimeUnit.SECONDS.sleep(4);
        return "1024";
    }
}

public  class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new MyThread2());
        FutureTask futureTask2 = new FutureTask(()->{
            System.out.println("callable is come");
            TimeUnit.SECONDS.sleep(4L);
            return 1204;
        });

        new Thread(futureTask,"A").start();
        new Thread(futureTask2,"B").start();

       // t1.setDaemon(true);//设置守护线程


        while(!futureTask2.isDone()){
            System.out.println("****请稍等");
            //get方法只会计算一次结果，如果不放在最后调用就会阻塞后面的程序。
            System.out.println(futureTask2.get());
            System.out.println(futureTask.get());
            System.out.println("over");
        }

        System.out.println(futureTask2.get());
    }
}
