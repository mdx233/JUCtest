package ioStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamText {
    public static void main(String[] args) {
        FileInputStream fils = null; //保证finally中的fis能使用
        try {
            fils = new FileInputStream("newAdvance\\src\\ioStream\\temp");//创建文件对象，路径为相对路径，其中idea的默认当前路径是当前项目的根路径
            byte[] bytes = new byte[fils.available()]; //fils.availab（）返回流中没有读到的文件的字节数量
            //该方式不适合大的文件，因为byte[]数组长度不适合太大

            //开始读，read（）返回读到字节的ascll码，每次调用read（），read（）指针在原来基础上后移一位，直到读取不到返回-1
            //read（byte[]）方法一次读取byte.length个字节，将读取到的字节放入byte[]数组中，返回读取到的字节数量，
            int readCount = fils.read(bytes);

            //String[byte[],int offset,int count]将byte数组从offset位置开始将count个转换成字符串
            System.out.print(new String(bytes,0,readCount));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fils != null) { //防止空指针异常
                try {
                    fils.close(); //关闭字节输入流
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
