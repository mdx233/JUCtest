package collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    public static void main(String[] args) {
        //创建HashSet集合
        HashSet<String>  set= new HashSet<>();
        //添加集合中元素
        set.add("asdf");
        set.add("zvzg");
        set.add("fadfa");
        set.add("sdfadf");
        set.add("asdvcx");

        System.out.println("====================");

        Iterator<String> it = set.iterator();

        //通过迭代器遍历
        while (it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("====================");
        //通过foreach增强循环遍历
        for(String s : set){
            System.out.println(s);
        }

    }
}
