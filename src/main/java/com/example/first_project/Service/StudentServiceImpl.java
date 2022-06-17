package com.example.first_project.Service;

import com.example.first_project.model.Student;
import com.example.first_project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student StudentGet(Integer id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void studentDelete(Integer id) {
        studentRepository.deleteById(id);
    }

}
