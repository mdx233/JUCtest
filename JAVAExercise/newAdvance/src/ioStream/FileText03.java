package ioStream;

import java.io.File;

public class FileText03 {
    public static void main(String[] args) {
        //File[] listFiles()
        //获取当前目录下的所有子文件


        File f = new File("newAdvance\\src\\ioStream");
        File[] files = f.listFiles();

        //foreach循环
        for(File ff:files){
            //获取文件名
            System.out.println(ff.getName());
        }
    }
}
