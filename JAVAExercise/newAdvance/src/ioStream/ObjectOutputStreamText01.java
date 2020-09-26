package ioStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
*
* ObjectOutputStream
* 序列化
*
*
* */
public class ObjectOutputStreamText01 {
    public static void main(String[] args) throws Exception {
        XIXIXI s = new XIXIXI("ZHANGSAN",111);
        FileOutputStream fout = new FileOutputStream("students");
        ObjectOutputStream obo = new ObjectOutputStream(fout);

        obo.writeObject(s);

        //刷新
        obo.flush();
        //关闭
        obo.close();

    }
}
