package JUC工具类;

import java.util.concurrent.CountDownLatch;

/**
 *功能描述
 * @author mdx
 * @date 2020/8/17
 * @param
 * @return
 *
 *  设置多个线程，规定一个线程在所有线程执行完后才执行。
 *  CountDownLatch
 *  CountDownLatch构造方法传入一个int类型整数，设置计数器个数。
 *  计数器await方法使调用该方法的线程进入阻塞状态，只有在计数器为0的状态下才能被唤醒。
 *  countDown方法减少一个计数器。
 * JUC辅助类
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //传入一个参数，代表线程计数器数
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"离开教室");
                //countDown方法执行，减少一个计数器
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        //await()方法，使当该线程进入阻塞状态，只有当计数器减少为0时才唤醒该线程
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"关门走人");
    }
}
