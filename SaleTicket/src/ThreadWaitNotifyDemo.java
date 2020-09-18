/**
 *功能描述
 * @author mdx
 * @date 2020/8/16
 * @param
 * @return
 * 题目：现在两个线程，可以操作初始值为零的一个变量，
 * 实现一个线程对变量加1，一个线程对该变量减1
 * 实现交替，来10轮，变量初始值为零
 *
 * 1    高聚第低合前提下，线程操作资源类
 * 2    判断/操作/通知
 * 3    多线程交互中，必须要防止多线程的虚假唤醒，即（判断只用while，不能使用if）
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();

        new Thread(()->{
            for (int i = 0;i <=10;i++){
                airConditioner.increment();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0;i <=10;i++){
                airConditioner.decrement();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0;i <=10;i++){
                airConditioner.increment();
            }
        },"C").start();

        new Thread(()->{
            for (int i = 0;i <=10;i++){
                airConditioner.decrement();
            }
        },"D").start();
    }
}

class AirConditioner{
    private int number = 0;
    public synchronized void increment(){
        //1 判断
        while (number != 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //2 操作
        number++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //3 通知
        this.notifyAll();
    }

    public synchronized void decrement(){
        //1 判断
        while (number == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //2 操作
        number--;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //3 通知
        this.notifyAll();
    }
}
