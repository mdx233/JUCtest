package JUC工具类;

public class ExamThread01 {
    public static void main(String[] args) {
        MyClass mc = new MyClass();
        Thread t1 = new MyThread(mc);
        t1.setName("t1");
        Thread t2 = new MyThread(mc);
        t2.setName("t2");
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}

class MyThread extends Thread{

    private MyClass myClass;

    public MyThread(MyClass myClass) {
        this.myClass = myClass;
    }

    @Override
    public void run() {
        if("t1".equals(Thread.currentThread().getName())){
            myClass.m1();
        } else if("t2".equals(Thread.currentThread().getName())){
            myClass.m2();
        }
    }
}

class MyClass{
    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName() + "'s m1 method begin");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "'s m1 method over");
    }
    public synchronized void m2(){
        System.out.println(Thread.currentThread().getName() + "'s m2 method execute");
    }
}
