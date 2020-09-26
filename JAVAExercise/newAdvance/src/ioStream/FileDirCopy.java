package ioStream;

import org.w3c.dom.ls.LSOutput;

import java.io.*;

/*
* 拷贝目录
*
* */
public class FileDirCopy {
    public static void main(String[] args) {
        //拷贝源
        File srcFile = new File("D:\\JAVAExercise\\newAdvance\\src");
        //拷贝目标
        File destFile = new File("C:\\");
        //调用拷贝方法
        Copydir(srcFile,destFile);
    }

    private  static  void Copydir(File srcFile,File destFile){
        if(srcFile.isFile()){
            //srcFile如果是一个文件的话递归结束
            //是文件的时候需要拷贝
            FileInputStream in = null;
            FileOutputStream out = null;

            try {
                //读这个文件
                in = new FileInputStream(srcFile);
                String path = (destFile.getAbsolutePath().endsWith("\\") ? destFile.getAbsolutePath() : destFile.getAbsolutePath() + "\\") + srcFile.getAbsolutePath().substring(3);
                //写到这个文件中
                out = new FileOutputStream(path);

                //一边读一边写
                byte[] bytes = new byte[1024 * 1024];
                int readCount = 0;
                while((readCount = in.read(bytes)) != -1){
                    out.write(bytes,0,readCount);
                }

                out.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("该文件写入完毕！");;
            return;
        }
        int i = 0;
        //获取源目录下的子目录
        File[] files = srcFile.listFiles();
        for(File file : files){
            System.out.println(files.length+"个");
            System.out.println(file.getAbsolutePath());
            //如果是目录新建目录
            if(file.isDirectory()){
                String srcDir = file.getAbsolutePath();

                System.out.println(srcDir);
                String destDir = (destFile.getAbsolutePath().endsWith("\\") ? destFile.getAbsolutePath() :destFile.getAbsolutePath() + "\\") + srcDir.substring(3);

                File newFile = new File(destDir);
                System.out.println(destDir);
                if(!newFile.exists()){
                    newFile.mkdirs();
                }
            }
            //递归调用
            Copydir(file,destFile);
        }
    }
}
