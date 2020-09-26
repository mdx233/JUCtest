package ioStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.SQLOutput;

public class PrintStreamText01 {
    public static void main(String[] args) {
        try {
            //创建一个字节输出流对象
            FileOutputStream out = new FileOutputStream("new.txt",true);
            //创建一个标准输出流，并将字节输出流对象传入到其构造函数中
            PrintStream ps = new PrintStream(out);
            //改变这标准输出流方向，使其输出到new.txt文件中
            System.setOut(ps);

            System.out.println("你好！");
            System.out.println("起飞!");

            ps = System.out;
            System.setOut(ps);

            System.out.println("测试");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
