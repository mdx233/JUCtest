import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //饿汉式,直接实例化饿汉式
        Singleton1 s1 = Singleton1.INSTANCE;
        Singleton1 s2 = Singleton1.INSTANCE;
        System.out.println(s1 == s2);

        //饿汉式,枚举类型
        Singleton2 s4 = Singleton2.INSTANCE;
        Singleton2 s5 = Singleton2.INSTANCE;
        System.out.println(s5 == s4);

        //懒汉模式测试
        Callable<Singleton4> callable = ()-> Singleton4.getInstance();

        //创建线程池
        ExecutorService ThreadPool = Executors.newFixedThreadPool(2);
        Future<Singleton4> future1 = ThreadPool.submit(callable);
        Future<Singleton4> future2 = ThreadPool.submit(callable);

        Singleton4 s41 = future1.get();
        Singleton4 s42 = future2.get();

        System.out.println(s41 == s42);
    }
}
