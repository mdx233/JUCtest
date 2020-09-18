package JUC工具类;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *功能描述
 * @author mdx
 * @date 2020/8/17
 * @param
 * @return
 *
 * 该工具类规定了一个方法在最后执行。
 * CyclicBarrier
 * 构造方法传入一个int数据类型参数，一个Runnable接口，最后执行该Runnable接口实现的run方法。
 * await方法，当该方法调用次数达到构造函数中规定的次数时，执行构造函数中Runnable接口的run方法。
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        //传入一个int类型的整数，传入一个Runnable实现类，该实现类的run方法为最后执行的方法；
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("芜湖，起飞");
        });

        for (int i = 1; i <= 7; i++) {
            final int tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t收到第"+tempInt);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
