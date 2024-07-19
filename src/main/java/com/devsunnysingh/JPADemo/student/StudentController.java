package com.devsunnysingh.JPADemo.student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    StudentService studentService;

    public StudentController(StudentService service) {
        this.studentService=service;
    }

    @PostMapping("/students")
    public StudentResponseDto post(@RequestBody StudentDTO dto){
        return this.studentService.saveStudent(dto);
    }
    @GetMapping("/students")
    public List<StudentResponseDto> finaAllStudent() {

        return studentService.findAllStudents();
    }
    @GetMapping("/students/{sid}")
    public StudentResponseDto findById(@PathVariable("sid") Integer sid){
        System.out.println("Value of sid is: " + sid);
        return studentService.findStudentById(sid);
    }
    @GetMapping("/students/firstname/{firstName}")
    public List<StudentResponseDto> findAllByFirstNameContaining(@PathVariable("firstName") String firstName) {
        return studentService.findAllStudentsByFirstNameContaining(firstName);
    }

    @DeleteMapping("/students/{sid}")
    public String deleteStudentRecord(@PathVariable("sid") Integer sid) {
        return studentService.deleteStudentRecordById(sid);

    }

}
