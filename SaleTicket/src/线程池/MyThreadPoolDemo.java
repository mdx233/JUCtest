package 线程池;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class MyThreadPoolDemo {
    public static void main(String[] args) {
        //设置一池，五个线程，该线程池中有五个线程，类似一个银行有五个受理窗口
        //固定的，FixedThreadPool规定了固定的线程数
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);


        //单例的，规定了一个池只有一个线程
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();


        //可扩容的，规定了一池有N个线程，动态的获取线程
        //ExecutorService threadPool = Executors.newCachedThreadPool();

        //自定义线程池，自己设施 核心线程数，最大线程数，线程等待时间，等待时间单位，阻塞队列，线程工厂类，拒绝策略
        ExecutorService threadPool = new ThreadPoolExecutor(
                2
                ,5
                ,1L
                , TimeUnit.SECONDS
                ,new LinkedBlockingQueue<>(3)
                ,Executors.defaultThreadFactory()
                ,new ThreadPoolExecutor.AbortPolicy());
        //以上自定义线程池，最大可接收任务数为最大线程数+阻塞队列容量，如果任务超过线程池最大承受量，就会触发拒绝策略。
        try{
            //模拟10个客户
            for (int i = 1; i <=10 ; i++) {
                //从线程池中获取线程
                threadPool.execute(()->{
                    //设置线程的执行方法
                    System.out.println(Thread.currentThread().getName()+"\t 受理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //执行完毕，关闭线程
            threadPool.shutdown();
        }
    }
}
