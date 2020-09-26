/**
 *  父类的初始化<clinit>;
 *  (1) j = method();
 *  (2) 父类的静态代码块
 *
 *  父类的实例初始化<init>
 *  (1) super() (最前，一定在最前)
 *  (2) i = test(); (2和3谁在前谁先执行)
 *  (3) 父类的非静态代码块
 *  (4) 父类的无参构造(最后，一定在最后)
 *
 *  方法重写Override
 *  非静态方法前面其实有一个默认的对象this
 *  this在构造器(或<init>)它表示的时正在创建的对象，因为这里是在创建Son对象，
 *  所以test()执行的是子类重写的代码(面向对象多态)
 *
 *  这里i=test()执行的是子类重写的test()方法
 *
 *  1、哪些方法不可以被重写
 *  final方法
 *  静态方法
 *  private等子类中不可见方法
 *
 *  2.对象的多态性
 *  子类如果重写了父类的方法，通过子类对象调用的一定是子类重写过的代码
 *  非静态方法默认的调用对象是this
 *  this对象在构造器或者说<init>方法中就是正在创建的对象
 */
public class Father {
    private int i = text();
    private static int j = method();
    static {
        System.out.print("(1)");
    }
    public Father(){
        System.out.print("(2)");
    }

    {
        System.out.print("(3)");
    }

    public int text(){
        System.out.print("(4)");
        return 1;
    }
    public static int method(){
        System.out.print("(5)");
        return 1;
    }
}
