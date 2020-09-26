package thread;

public class ThreadWork {
    public static void main(String[] args) {
        T a = new T(1);
        Thread t1 = new Thread(new T1Thread(a));
        t1.setName("t1");
        Thread t2 = new Thread(new T2Thread(a));
        t2.setName("t2");
        t1.start();
        t2.start();

    }
}
class T1Thread implements Runnable{

    T a;

    public T1Thread(T a) {
        this.a = a;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 10){
            synchronized (a){
                if(a.getA()%2 == 0){
                    try {
                        a.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"-->"+a.getA());
                a.setA(a.getA()+1);
                i++;
                a.notify();
            }
        }

    }
}

class T2Thread implements  Runnable{
    T a;

    public T2Thread(T a) {
        this.a = a;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 10){
            synchronized (a){
                if(a.getA()%2 != 0){
                    try {
                        a.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"-->"+a.getA());
                a.setA(a.getA()+1);
                i++;
                a.notify();
            }
        }


    }
}

class T{
    int a;

    public T(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
