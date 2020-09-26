package ioStream;

/*
* BufferedReader:
*   带有缓冲区的字节输入流，
*   不需要创建自定义的char数组，或者说不需要自定义的缓冲区
*
*
* */

import java.io.*;

public class FileBuffereReaderText01 {
    public static void main(String[] args) {

        BufferedReader br = null;

        try {
            //创建节点流对象
            FileInputStream in = new FileInputStream("new");
            //转换流将字节输入流转换成字符输入流
            InputStreamReader reader = new InputStreamReader(in);
            //br对象为包装流，将节点流传入，关闭时只需要关闭包装流，BuffereReader对象构造函数参数只能传入字符流，如果需要传入字节流则需要转换流
            br = new BufferedReader(reader);
            String s;
            while ((s = br.readLine()) != null){
                System.out.println(s);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br == null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
