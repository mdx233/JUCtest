package ioStream;

import java.io.File;
import java.io.IOException;

public class FileText01 {
    public static void main(String[] args) {
        /*//创建一个File对象
        File f1 = new File("D:\\file");
        //exists()方法判断是否存在
        System.out.println(f1.exists());

        //如果D:\\file不存在，则以目录形式创建出来
        if(!f1.exists()){
            //如果不存在以文件的形式新建
            *//*try {
                f1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }*//*

            //如果不存在以目录的形式新建
            f1.mkdir();
        }*/

        //创建一个File对象
        File f2 = new File("newAdvance\\src\\ioStream\\temp");
        //获取父文件路径
        System.out.println(new String(f2.getParent()));
        //获取父文件
        File parentFile = f2.getParentFile();
        //获取父文件绝对路径
        System.out.println(parentFile.getAbsolutePath());
        //获取绝对路径
        System.out.println(new String(f2.getAbsolutePath()));
    }
}
