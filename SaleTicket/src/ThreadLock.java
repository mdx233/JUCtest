import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
 * 4    标志位
 * 使用lock
 */
public class ThreadLock {
    public static void main(String[] args) {
        //资源类创建
        Air air = new Air();
        //线程创建，使用lambda表达式
        new Thread(() -> {
            //重写run方法，调用资源类。
            air.increment();
        },"A").start();

        new Thread(() -> {
            //重写run方法，调用资源类。
            air.decrement();
        },"B").start();

        new Thread(() -> {
            //重写run方法，调用资源类。
            air.increment();
        },"C").start();

        new Thread(() -> {
            //重写run方法，调用资源类。
            air.decrement();
        },"D").start();
    }
}

class Air{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment(){
        //多线程资源类加锁，防止该线程操作时其他类对该资源进行访问。
        lock.lock();
        //lock之后的操作需要放到try catch语句中
        try{
            //1 判断
           while(number !=0 ){
              //如果不符合操作条件使线程进入阻塞状态
               condition.await();
           }
           //2  通过判断之后进行操作
            number++;
           //3  操作完成之后唤醒其它阻塞的线程
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //在使用完成之后释放锁
            lock.unlock();
        }
    }

    public void decrement(){
        //多线程资源类加锁，防止该线程操作时其他类对该资源进行访问。
        lock.lock();
        //lock之后的操作需要放到try catch语句中
        try{
            //1 判断
            while(number == 0 ){
                //如果不符合操作条件使线程进入阻塞状态
                condition.await();
            }
            //2  通过判断之后进行操作
            number--;
            //3  操作完成之后唤醒其它阻塞的线程
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //在使用完成之后释放锁
            lock.unlock();
        }
    }
}