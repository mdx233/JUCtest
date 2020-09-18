public class Test {
    public static void main(String[] args) {
        source source = new source();
        Thread t1 = new Thread(source,"A");
        Thread t2 = new Thread(source,"B");

        t1.start();
        t2.start();
    }
}
class source implements Runnable{

    private int s = 0;

    @Override
    public synchronized void run() {
        synchronized (this){
            for(int i =0 ;i < 10 ;i++){
                s+=i;
            }
        }

        System.out.println(Thread.currentThread().getName()+":"+s);
    }
}
