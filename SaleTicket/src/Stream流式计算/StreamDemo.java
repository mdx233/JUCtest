package Stream流式计算;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/**
 *功能描述
 * @author mdx
 * @date 2020/8/18
 * @param
 * @return
 * 题目：请按照给出数据，找出同时满足一下条件的用户，也即以下条件全部满足
 *      偶数ID
 *      且年龄大于24
 *      且用户名转为大写
 *      且用户名字母倒排序
 *      只输出一个用户名字
 */

public class StreamDemo {
    public static void main(String[] args) {
        User u1 = new User(11,"a",23);
        User u2 = new User(12,"b",24);
        User u3 = new User(13,"c",22);
        User u4 = new User(14,"d",28);
        User u5 = new User(16,"e",26);

        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);

        //将list转换为stream
        list.stream().filter(
                //filter过滤方法，filter中传入一个供给型函数式接口
                //使用判断型接口，实现方法，判断流中id为偶数的user
                user -> {
                    return user.getId()%2==0;
                }
        ).filter(
                //filter过滤方法，filter中传入一个供给型函数式接口
                //使用判断型接口，实现方法，判断通过上一次过滤之后剩下的user中age大于24的user
                user -> {
                    return user.getAge()>24;
                }
        ).map(
             //map映射方法，传入一个函数型函数式接口
             //通过函数方法，将经过上两次过滤后的user只输出userName并且userName转为大写
             user -> {
                 return user.getUserName().toUpperCase();
             }
        ).sorted(
                //sorted方法默认为升序，如果传入一个compareTo接口时，自定义排序方法
                Comparator.reverseOrder()
        //limit限制输出个数
        ).forEach(System.out::println);
    }
}
