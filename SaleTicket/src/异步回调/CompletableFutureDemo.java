package 异步回调;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(
                () ->{
                    System.out.println(Thread.currentThread().getName()+"\t 没有返回值");

                }
        );
        completableFuture.get();

        //异步回调,有返回值
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(
                ()->{
                    System.out.println(Thread.currentThread().getName()+"\t ----异步回调");
                    int a = 10/0;
                    return 1024;//return的值类型与上面定义的泛型一致
                }
        );
        completableFuture2.whenComplete(
                //t为上面方法中的返回值，u为异常信息
                //该方法为消费型函数式接口的变型，t为传入对象，u为异常对象
                (t,u) -> {
                    //如果上面方法正常执行，并且返回值，t为return的值，u为null
                    //如果上面方法有异常，并且没有返回值，则t为null，u为异常信息
                    System.out.println("****t: "+t);
                    System.out.println("****u: "+u);
                }
        ).exceptionally(//此方法只有在上方的Runnable接口方法报错时才执行，并且return一个与上面接口指定泛型相同的返回值，可以通过sout输出。
                //该方法为函数型函数式接口
                f ->{
                    System.out.println("***excption: "+f.getMessage());
                    return 444;//再出现异常时返回值，可以通过.get获得,通过.sout打印在控制台
                }
        ).get();

        //以上方法体现链式编程
    }
}
