package JUC工具类;

import java.util.TreeMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *功能描述
 * @author mdx
 * @date 2020/8/17
 * @param
 * @return
 *
 * 该juc工具类用于规定多线程获取多资源时的操作，规定资源数量，使线程在有限的资源类中进行操作。
 *
 * 信号量上定义两种操作：
 *  acquire(获取) 当一个线程调用acquire操作时，它要么通过成功获取信号量(信号量减1)，
 *                要么一直等一下去，直到有线程释放信号量，或超时。
 *
 *  release(释放) 实际上会将信号量的值加1，然后唤醒等待的线程。
 *
 *  信号量主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制。
 */

public class SemaphoreDemo {
    public static void main(String[] args) {
        //模拟资源类，有三个空车位
        //规定总信号量
        Semaphore semaphore = new Semaphore(3);


        //模拟六个车，创建六个线程
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                try {
                    //获取资源(获取车位)，获取一个信号量，如果获取到，信号量减1，程序往下运行。
                    // 如果信号量为零时获取不到，程序阻塞，知道到有信号量释放出来被获取到才被唤醒。
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t抢到了车位");
                    //暂停线程一段时间
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"\t离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //最后释放资源(归还车位)
                    //将获取到的型号量归还
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
