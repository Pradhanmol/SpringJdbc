package org.SprinJdbc.dao;

import org.SprinJdbc.Student;
import org.springframework.context.annotation.Bean;

import java.util.List;
public interface StudentDao {
    public int insert(Student student);
    public int change(Student student);
    public int delete(Student student);

// for select single object
    public Student getStudent(int id);
    public List<Student> getAllStudent();

}
