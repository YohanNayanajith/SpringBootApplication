package com.example.first_project.controller;

import com.example.first_project.Service.StudentService;
import com.example.first_project.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String add(@RequestBody Student student){
        studentService.saveStudent(student);
        return "New student added";
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable Integer id){
        try {
            Student student = studentService.StudentGet(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String studentDelete(@PathVariable Integer id){
        studentService.studentDelete(id);
        return "Deleted Student with id "+id;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@RequestBody Student student,@PathVariable Integer id){
        try{
//            Student existingStudent = studentService.StudentGet(id);
            studentService.saveStudent(student);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }
}
