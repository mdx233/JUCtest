package thread;
/*
*
*
*
*
* */
public class ThreadTest01 {
    public static void main(String[] args) {
        //Main方法，这里代码属于主线程，在主栈中运行。
        //新建一个分支线程对象
        MyThread newthread = new MyThread();
        //start()方法的作用是：启动一个分支线程，在JVM中开辟一个新的栈空间，这段代码任务结束之一瞬间就结束了。
        //这段代码的任务只是为了开辟一个新的栈空间，只要新的栈空间开出来start（）方法就结束了。线程就启动成功了。
        //启动成功的线程会自动调用run方法，并且run方法在分支栈的栈底部（压栈）。
        //run方法在分支栈的栈底部，main方法在主栈的底部。run和main是平级的。
        newthread.start();
        //这里的代码还是运行在主线程中。
        for(int i = 0;i < 1000;i++){
            System.out.println("主线程--->"+i);
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        for (int i =0;i < 1000;i++){
            System.out.println("分支线程--->"+i);
        }

    }
}
