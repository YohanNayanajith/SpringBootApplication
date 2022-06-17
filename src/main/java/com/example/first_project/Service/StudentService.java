package com.example.first_project.Service;

import com.example.first_project.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Student StudentGet(Integer id);
    public void studentDelete(Integer id);
}
