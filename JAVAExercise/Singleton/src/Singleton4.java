/**
 * 懒汉式 什么时候需要,什么时候创建对象
 * (1)私有化构造器
 * (2)用一个静态变量保存这个唯一的实例
 * (3)提供一个静态方法,获取这个实例对象
 */
public class Singleton4 {
    private static Singleton4 instance;

    private Singleton4(){

    }

    public static Singleton4 getInstance() {
        //加一个外层判断,如果实例已经创建则不用再去获取锁,直接return实例
        if (instance == null) {
            //这种方式在多线程情况下不安全
            //需要加锁
            synchronized (Singleton4.class){
                if(instance == null){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
