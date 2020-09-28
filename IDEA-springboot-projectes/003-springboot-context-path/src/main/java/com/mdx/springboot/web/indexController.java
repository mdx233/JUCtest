package com.mdx.springboot.web;

import com.mdx.springboot.config.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class indexController {

    @Autowired
    private School school;

    // @Value("${school.name}")
    // private String schoolename;
    //
    // @Value("${website}")
    // private String web;

    @RequestMapping("/say")
    public @ResponseBody String say(String n){

        return "Hello :say:"+n+school.getName()+school.getWebsite();
    }

    @RequestMapping("/mapvalue")
    @ResponseBody
    public Map<String,Object> mapvalue(){
        Map<String,Object> retMap = new HashMap<>();
        retMap.put("message","SpringBoot Project");
        return retMap;
    }
}

