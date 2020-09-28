package com.example.springboot04web.controller;

import com.example.springboot04web.dao.DepartmentDao;
import com.example.springboot04web.dao.EmployeeDao;
import com.example.springboot04web.entities.Department;
import com.example.springboot04web.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);

        //thtmeleaf默认就会拼串
        //classpath:/templates/xxxx.html
        return "emp/list";
    }
    //来到员工添加页面
    @GetMapping("/emp")
    public  String toAddPage(Model model){
        //来到添加页面,查出所有部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return"emp/add";
    }

    //员工添加
    //SpingMVC自动将请求参数和入参对象的属性进行一一绑定：要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        //来到员工列表页面
        System.out.println(employee);
        //保存
        employeeDao.save(employee);
        //redirect:表示重定向到一个地址 /代表当前项目路径
        //forward:表示转发到一个地址
        return "redirect:/emps";//因为/emps为get请求，而网页请求方式为post，如果使用forward会出现405请求方式出错
    }

    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
         Employee employee = employeeDao.get(id);
         model.addAttribute("emp",employee);

         //页面要显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

         //回到修改页面（add是一个修改添加二合一的页面）
        return "emp/add";
    }

    //员工修改
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改员工数据："+employee);
        employeeDao.save(employee);

        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
