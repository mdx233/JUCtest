package 四大函数式接口;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionDemo {
    public static void main(String[] args) {
        //Function<T,R>函数型接口，T为传入参数的类型，R为返回参数的类型
        //作用为接收一个T类型对象并返回一个R类型对象
        //包含方法 R apply(T t)

    /*Function<String,Integer> function = new java.util.function.Function() {
        @Override
        public Object apply(Object o) {
            return null;
        }
    };*/
        //lambda表达式实现
        Function<String,Integer> function = s -> {return s.length();};
        System.out.println(function.apply("mdx"));

        //Predicate<T>断定型接口，T为传入参数的类型，返回一个boolean值
        //作用确定类型为T的对象是否满足约束，并返回boolean值
        //包含方法 Boolean test(T t)

        /*Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };*/

        //lambda表达式实现
        Predicate<String> predicate = s ->{return s.isEmpty();};
        System.out.println("判断型接口，传入值mdx"+predicate.test("mdx"));
        System.out.println("判定型接口，传入值为空字符串"+predicate.test(""));


        //Consumer<T>消费型接口，T为传入参数的类型，返回类型为void
        //作用确定类型为T的对象应用操作
        //包含方法 void accept(T t)

        /*Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {

            }
        };*/

        //lambda表达式实现
        Consumer<String> consume  = s ->{
            System.out.println(s.length());
        };
        consume.accept("mdx01");

        //Supplier<T>供给型接口，返回类型为T的对象
        //作用返回类型为T的对象应用操作
        //包含方法 T get()

        /*Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return null;
            }
        };*/

        //lambda表达式实现
        Supplier<String> supplier = () ->{return "mdx";};
        System.out.println(supplier.get());
    }


}
