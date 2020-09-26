/**
 * 饿汉式 直接创建这个对象,不管需不需要获取这个对象,应为对象在类加载时就创建,所以不存在线程安全问题
 * 1.构造器私有化
 * 2.自行创建,用静态变量保存
 * 3.向外提供这个实例
 * 4.强调这是一个单例,用final关键字修饰,表示这是一个不可变的
 */
public class Singleton1 {
    //使用public向外提供,使用static可直接通过类名获取,使用final来保证赋值之后不可变保证单例
    public static final Singleton1 INSTANCE = new Singleton1();
    private Singleton1(){

    }

}
