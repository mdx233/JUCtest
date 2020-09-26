package ioStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyText02 {
    public static void main(String[] args) {
        FileReader in = null;
        FileWriter out = null;

        try {
            in = new FileReader("newAdvance\\src\\ioStream\\temp");
            out = new FileWriter("new",true);

            //创建一个存储容量为1MB的char[]数组
            char[] chars = new char[1024 * 1024];

            int readerCount = 0;
            //将字符输入流文件对象输入到chars数组中
            while ((readerCount = in.read(chars)) != -1){
                //将chars数组中的字符输出到字符输出流文件对象中
                out.write(chars,0,readerCount);

                System.out.println("复制文本内容为：\n"+new String(chars,0,readerCount));
            }

          //刷新
            out.flush();
            System.out.println("\n");
            System.out.println("复制完成！");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (in == null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out == null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
