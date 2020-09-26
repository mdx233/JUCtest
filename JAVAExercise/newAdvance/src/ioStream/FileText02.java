package ioStream;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/*

File类的常用方法

*/
public class FileText02 {
    public static void main(String[] args) {

        File f1 = new File("newAdvance\\src\\ioStream\\temp");

        //获取文件名
        System.out.println("文件名:"+f1.getName());

        //判断是否是一个目录
        System.out.println(f1.isDirectory());//false

        //判断是否是一个文件
        System.out.println(f1.isFile());//true

        //获取文件最后一次修改时间
        long haomiao =  f1.lastModified();
        //将总毫秒数转换成日期
        Date time = new Date(haomiao);
        //时间格式化
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String thistime = date.format(time);
        System.out.println(thistime);

        //获取文件大小
        System.out.println(f1.length());


    }
}
