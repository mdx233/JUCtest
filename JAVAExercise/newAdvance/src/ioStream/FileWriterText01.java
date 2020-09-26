package ioStream;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;

public class FileWriterText01 {
    public static void main(String[] args) {
        FileWriter writer = null;

        try {
            //创建文件字符输出流对象
            writer = new FileWriter("newtemp",true);

            //创建char[]数组
            char[] chars = {'芜','湖','起','飞'};
            //将char[]数组内容写入文件对象中
            writer.write(chars);
            //写入换行符
            writer.write("\n");
            //输出流完毕之后一定要刷新
            writer.flush();
            System.out.println("char[]数组输入完毕");

            String s = new String("芜湖大司马");
            //将字符数组输入到文件对象中
            writer.write(s);
            //输出流完毕之后一定要刷新
            writer.flush();
            System.out.println("字符串输入完毕");


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (writer == null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
