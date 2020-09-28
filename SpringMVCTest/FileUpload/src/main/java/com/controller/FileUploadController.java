package com.controller;

import jdk.internal.util.xml.impl.Input;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;


@RestController
public class FileUploadController {
    @RequestMapping("/upload1")
    public String FileUpLoad1(@RequestParam("file")CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        //获取文件名:file.getOriginalFilename();
        String uploadname = file.getOriginalFilename();

        //入果文件名为空，则说明没有文件上传，返回首页。
        if ("".equals(uploadname)){
            return "redirect:/index.jsp";
        }
        System.out.println("上传文件名："+uploadname);

        //设置文件上传之后指定的路径
        String path = request.getServletContext().getRealPath("/upload");
        //如果路径不存在，创建一个
        File realPath = new File(path);
        if(!realPath.exists()){
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址:"+realPath);

        InputStream is = file.getInputStream();//文件输入流
        OutputStream os = new FileOutputStream(new File(realPath,uploadname));//文件输出流

        //创建缓冲区
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len = is.read(buffer)) != -1){
            os.write(buffer,0,len);
            os.flush();
        }

        os.close();
        is.close();
        return "文件上传成功！";
    }

    @RequestMapping("/upload2")
    public String upload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request){
        //获取文件上传路径
        String path = request.getServletContext().getRealPath("/upload2");
        //获取文件名
        String uploadname = file.getOriginalFilename();
        //判断文件名是否为空
        if ("".equals(uploadname)){
            //如果文件名为空，则文件上传失败，需要重新上传
            return "文件名为空，请重新上传";
        }
        //创建file对象
        File realPath = new File(path);
        //判断路径是否存在
        if(!realPath.exists()){
            realPath.mkdir();
        }
        System.out.println("文件上传地址:"+realPath);
        try {
            //使用CommonsMultipartFile内置方法直接写文件
            file.transferTo(new File(realPath+"/"+uploadname));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "文件上传成功";
    }

    //下载文件方法
    @RequestMapping("/download")
    public String FileDownlo(HttpServletResponse response,HttpServletRequest request) throws UnsupportedEncodingException {
        //获取文件路径
        String path = "C:\\Users\\mdx\\Desktop\\JavaProject\\SpringMVCTest\\FileUpload\\src\\main\\resources\\1_180201163651_1.jpg";
        //获取文件名称
        String filename = path.substring(path.lastIndexOf("\\")+1);
        System.out.println(filename);
        //设置响应头，让浏览器知道这是一个下载的响应，调用下载器
        //如果文件名为中文，使用URLEncoder.encode()进行转码,防止文件名乱码
        filename = URLEncoder.encode(filename,"UTF-8");
        response.setHeader("Content-Disposition","attachment;filename="+filename);
        FileInputStream in = null;
        OutputStream os = null;
        //创建下载路径
        String downpath = request.getServletContext().getRealPath("/download");
        //获取下载文件的输入流
        try {
            in = new FileInputStream(path);
            //创建缓冲区
            int len = 0;
            byte[] buffer = new byte[1024];
            //获取输出对象
            os = new FileOutputStream(downpath);
            while ((len = in.read(buffer))!= -1){
                os.write(buffer,0,len);
                os.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




        return "下载文件";
    }
}
