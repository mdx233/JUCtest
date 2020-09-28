package com.mdx.springboot.StudentService;

import com.mdx.springboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

public interface StudentService {
    /**
     * 根据学生id查询详情
     * @param id
     * @return
     */
    Student queryStudentById(Integer id);
}
