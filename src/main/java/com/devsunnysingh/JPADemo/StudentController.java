package com.devsunnysingh.JPADemo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/students")
    public Student post(@RequestBody Student student){
        return studentRepository.save(student);

    }
    @GetMapping("/students")
    public List<Student> finaAllStudent() {
        return studentRepository.findAll();
    }
    @GetMapping("/students/{sid}")
    public Student findById(@PathVariable("sid") Integer sid){
        System.out.println("Value of sid is: " + sid);
        return studentRepository.findById(sid)
                .orElse(new Student());
    }
    @GetMapping("/students/firstname/{firstName}")
    public List<Student> findAllByFirstNameContaining(@PathVariable("firstName") String firstName) {
        return studentRepository.findAllByFirstNameContaining(firstName);
    }

    @DeleteMapping("/students/{sid}")
    public String deleteStudentRecord(@PathVariable("sid") Integer sid) {
        studentRepository.deleteById(sid);
        return "Student record deleted";
    }

}
