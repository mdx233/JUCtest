import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
* 题目：三个售票员  卖出 30张票
*
*  多线程编程的企业级套路+模板
*
*   1. 在高内聚低耦合的前提下，线程  操作(对外的提供的调用方法)  资源类
*
*
* */
public class SaleTicket {
    public static void main(String[] args) throws Exception{
        //线程操纵资源类
        Ticket ticket = new Ticket();

        //匿名内部类
        // new Thread(new Runnable() {
        //     @Override
        //     public void run() {
        //         for(int i =1;i<=40;i++){
        //             ticket.saleTicket();
        //         }
        //     }
        // },"A").start();

        //  new Thread(new Runnable() {
            //     @Override
            //     public void run() {
            //         for(int i =1;i<=40;i++){
            //             ticket.saleTicket();
            //         }
            //     }
            // },"B").start();

        // new Thread(new Runnable() {
        //          @Override
        //          public void run() {
        //              for(int i =1;i<=40;i++){
        //                  ticket.saleTicket();
        //              }
        //          }
        //      },"C").start();

        //Lambda表达式
        new Thread(() -> {for(int i =1;i<=10;i++) ticket.saleTicket();},"A").start();
        new Thread(() -> {for(int i =1;i<=20;i++) ticket.saleTicket();},"B").start();
        new Thread(() -> {for(int i =1;i<=30;i++) ticket.saleTicket();},"C").start();
        System.out.println("皮一下");
    }
}

class Ticket{//资源类

    private int number = 10;
    private Lock lock = new ReentrantLock();//ReentrantLock可重入锁

    public void saleTicket(){
        lock.lock();
        try {
            if(number > 0){

                System.out.println(Thread.currentThread().getName()+"\t卖出第"+(number--)+"\t还剩"+number+"张票");

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
