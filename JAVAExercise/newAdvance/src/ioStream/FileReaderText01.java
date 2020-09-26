package ioStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
* FileReader：
*       文件字符输入流，只能读取普通文本。
*       读取文本内容时，比较方便，快捷。
*
* */

public class FileReaderText01 {
    public static void main(String[] args) {
        FileReader reader = null;

        try {
            //创建文件字符输入流
            reader = new FileReader("newtemp");

            /*//准备一个char数组
            char[] chars = new char[4];
            //在char数组中读
            reader.read(chars); //按照字符的方式读取
            for(char c: chars){
                System.out.println(c);
            }*/

            //开始读
            char[] chars = new char[4];
            int readerCount = 0;
            while ((readerCount = reader.read(chars)) != -1){
                System.out.print(new String(chars,0,readerCount));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (reader == null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
