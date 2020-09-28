package com.mdx.springboot.StudentService;

import com.mdx.springboot.model.Student;

public interface StudentService {
    /**
     * 根据学生id查询详情
     * @param id
     * @return
     */
    Student queryStudentById(Integer id);

    /**
     * 根据学生id修改学生姓名
     * @param student
     * @return
     */
    Integer updateStudetName(Student student);
}
