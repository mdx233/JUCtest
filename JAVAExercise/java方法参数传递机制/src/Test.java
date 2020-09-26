import java.util.Arrays;

/**
 * 方法的参数传递机制
 *
 * 1、形参是基本数据类型
 *      传递数据值
 * 2、实参是引用数据类型
 *      传递地址值
 *      特殊的类型:String、包装类等对象不可变性(如果对其进行增加计算则原来地址数据不会改变、会创建新地址来存放计算后的数据)
 */
public class Test {
    public static void main(String[] args) {
        mytest m = new mytest();
        int i = 1;
        Integer x = 200;
        String str = "Hello";
        int[] a = {1,2,3,4,5};
        change(i,str,x,a,m);
        System.out.println("i="+i);
        System.out.println("str="+str);
        System.out.println("x="+x);
        System.out.println("a[]="+Arrays.toString(a));
        System.out.println("m.a="+m.a);
    }

    public static void change(int j,String s,Integer x,int[] a,mytest m){
        j += 1;
        s += "world";
        x += 1;
        a[0] += 1;
        m.a += 1;
    }
}
class mytest{
    public int a = 10;
}
