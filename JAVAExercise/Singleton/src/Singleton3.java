/**
 * 饿汉式
 * 静态代码块实现
 */
public class Singleton3 {
    public static final Singleton3 instance;

    static {
        instance = new Singleton3();
    }

    private Singleton3(){

    }
}
