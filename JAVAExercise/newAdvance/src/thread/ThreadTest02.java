package thread;
/*
*
* 实现一个线程的第二种方式，编写一个类实现java.lang.Runnable接口。
* */
public class ThreadTest02 {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        Thread t = new Thread(r);
        t.start();
        t.interrupt();

        for (int i =0;i<1000;i++){
            System.out.println("主线程---->"+i);
        }
    }
}

class MyRunnable implements Runnable{
    @Override
    public  void run(){
        for (int i =0;i<1000;i++){
            System.out.println("分支线程---->"+i);
        }
    }
}
