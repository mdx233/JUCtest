package ioStream;

import java.io.*;

public class BuffereWriterText01 {
    public static void main(String[] args) {
        BufferedWriter bw = null;
        try {
            //创建字节输出对象，（节点流）
            FileOutputStream out = new FileOutputStream("new",true);
            //创建转换流
            OutputStreamWriter writer = new OutputStreamWriter(out);
            //创建包装流，并传入节点流
            bw = new BufferedWriter(writer);

            bw.write("\n");
            bw.write("哈哈哈哈！");


            //输入完毕之后刷新
            bw.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bw == null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
