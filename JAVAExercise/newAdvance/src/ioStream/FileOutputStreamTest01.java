package ioStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest01 {
    public static void main(String[] args) {
        FileOutputStream fos = null;

        try {
            //文件不存在时会自动新建
            //这种方式当文件存在时会将原文件清空再写入
            //fos = new FileOutputStream("newtemp");
            //以追加的方式在文件末尾写入，不会清空原文件内容
            fos = new FileOutputStream("newtemp",true);

            //开始写
            byte[] bytes = {97,98,99,100};
            //将byte数组全部写出
            fos.write(bytes); //abcd
            //将byte数组从下标开始，写出一定长度
            fos.write(bytes,1,3); //再写入bcd

            //写入字符串
            String s = "人在屋檐下，不得不低头";
            byte[] bs = s.getBytes();//将字符串转换成byte[]数组
            fos.write(bs);

            //写完之后，最后一定要刷新
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
