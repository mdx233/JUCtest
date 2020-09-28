package com.mdx.springboot.web;

import com.mdx.springboot.model.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @RequestMapping("/user/detail")
    public String message(Model model){
        User user = new User();
        user.setName("lisi");
        user.setId(1001);
        user.setAge(18);

        model.addAttribute("user",user);

        model.addAttribute("message","SpringBoot Thymeleaf 你好！");
        model.addAttribute("data","测试!");
        return "message";
    }

    @RequestMapping("/test")
    public @ResponseBody String test(String username){
        return "请求路径test参数是:"+username;
    }

    @RequestMapping("/test2/{id}")
    public @ResponseBody String test(@PathVariable("id") Integer id){
        return "请求路径id参数是:"+id;
    }

    @RequestMapping("/test1")
    public @ResponseBody String test1(String username,String data,String message){
        return "请求路径test参数是:"+username+"data="+data+"message="+message;
    }

    @RequestMapping("/each/list")
    public String eachList(Model model){
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(Integer.valueOf("100"+i));
            user.setAge(18+i);
            user.setName("张"+i);
            userList.add(user);
        }
        model.addAttribute("userlist", userList);

        return "each";
    }

    @RequestMapping("/each/Array")
    public String eachArray(Model model){
        User[] userarray = new User[10];
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(Integer.valueOf("100"+i));
            user.setAge(18+i);
            user.setName("张"+i);
            userarray[i] = user;
        }
        model.addAttribute("userArray", userarray);

        return "each";
    }

    @RequestMapping("/each/map")
    public String eachMap(Model model){
        Map<Integer,Object> usermap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(Integer.valueOf("100"+i));
            user.setAge(18+i);
            user.setName("张"+i);
            usermap.put(i,user);
        }
        model.addAttribute("usermap",usermap);
        return "each";
    }

    @RequestMapping("/condition")
    public String condition(Model model, Integer sex){
        model.addAttribute("sex",sex);
        return "condition";
    }

    @RequestMapping("/Sessiontest")
    public String sessiontest(HttpServletRequest request,Model model){

        model.addAttribute("userName","lisi");
        request.getSession().setAttribute("data","sessionData");
        return "condition";
    }
}
