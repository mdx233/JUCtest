
interface Foo{
    // public void sayHello();
    // public int add();
    public int add(int x,int y);
    //default语法不算为普通方法，如果接口已经只有一个方法，default方法不破坏影响一个接口为函数式接口。
    default int div(int x,int y){
        System.out.println("default java");
        return x*y;
    }
    //静态方法也可以在接口中实现，同时不影响接口作为一个函数式接口
    public static int mv(int x,int y){
        System.out.println("Static funcation");
        return x/y;
    }

}
/*
* 2 Lambda Express
*   2.1 口诀:
*       拷贝小括号(形参列表)，写死右箭头->，落地大括号 {方法实现}
*   2.2 @FunctionalInterface函数式接口，在接口默认有且只有一个方法时，系统底层默认加上。此时这个接口为函数式接口。
*
*   2.3 java8之后接口可以允许方法部分实现，
*       default实现接口中方法
*   2.4 静态方法实现接口中方法
* */
public class LambdaExpressDemo {
    public static void main(String[] args) {
        /*Foo foo = new Foo() {
            @Override
            public void sayHello() {
                System.out.println("hello java123456");
            }
        };
        foo.sayHello();*/

        //lambda表达式创建接口实例，一般适用于接口为函数式接口，即接口除了default方法和静态方法之外只有一个方法，则该接口为函数式接口。
        Foo foo = ( x, y)->{
            System.out.println("come in here");
            return x+y;
        };
        int x = foo.add(1,2);
        System.out.println(x);
        int y = foo.div(1,3);
        System.out.println(y);
        int s = Foo.mv(4,2);
        System.out.println(s);
    }
}
