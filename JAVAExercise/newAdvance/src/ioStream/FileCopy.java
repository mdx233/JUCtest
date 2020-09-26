package ioStream;


import java.io.*;

//使用FileInputStream + FileOutputStream完成文件的拷贝
/*
拷贝的过程时一边读，一边写。
使用以上的字节流拷贝文件的时候，文件类型随意，万能的。什么样的文件都能拷贝

*/
public class FileCopy {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        FileInputStream fis = null;

        try {
            //创建一个输入流对象
            fis = new FileInputStream("D:\\实训录屏\\日期转化器.mp4");
            //创建一个输出流对象
            fos = new FileOutputStream("D:\\转化器.mp4");

            //最核心的:一边读，一边写
            byte[] bytes = new byte[1024 * 1024]; //1MB(一次最拷贝1MB)
            int readCount = 0;
            while ((readCount = fis.read(bytes)) != -1){
                fos.write(bytes,0,readCount);
            }
            System.out.printf("复制成功！！");

            //刷新，输出流最后要刷新
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //分开处理异常，防止其中一个出异常导致另一个流无法关闭
            if (fis == null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos == null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
