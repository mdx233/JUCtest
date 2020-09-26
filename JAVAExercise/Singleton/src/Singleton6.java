/**
 * 使用静态内部类去加载实例
 * 再内部类被加载时和初始化时，才创建INSTANCE实例对象
 * 静态内部类不会自动随着外部类的加载和初始化而初始化，它是要单独去加载和初始化的。
 * 因为是在内部类加载和初始化时创建的，因此时线程安全的。
 */
public class Singleton6 {
    private Singleton6(){

    }
    private static class inner{
        private static final Singleton6 INSTANCE = new Singleton6();
    }
    public static Singleton6 getInstance(){
        return inner.INSTANCE;
    }
}
