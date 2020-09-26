package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class collectionTest01 {
    public static void main(String[] args) {
        //新建Arraylist对象
        ArrayList<Integer> list = new ArrayList<>();
        //新譖ArrayList内容
        list.add(12);
        list.add(13);
        list.add(1);
        list.add(2);
        list.add(5);

        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("=======================");
        for(int i : list){
            System.out.println(i);
        }
        System.out.println("=======================");
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }


}
