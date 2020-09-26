package ioStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;


public class ObjectInputStreamTest {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students"));
        //开始反序列化，读
        Object obj = ois.readObject();
        //反序列化回来是一个学生对象.所以会调用学生队形的toString()方法
        System.out.println(obj);
        ois.close();
    }
}
