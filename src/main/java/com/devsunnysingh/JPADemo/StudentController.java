package com.devsunnysingh.JPADemo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;
    private Student toStudent(StudentDTO studentDTO) {
        var student = new Student();
        student.setFirstName(studentDTO.firstName());
        student.setLastName(studentDTO.lastName());
        student.setEmail(studentDTO.email());
        var school = new School();
        school.setId(studentDTO.schoolId());

        student.setSchool(school);
        return student;
    }

    private final StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(student.getFirstName(), student.getLastName(), student.getEmail());
    }

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/students")
    public StudentResponseDto post(@RequestBody StudentDTO dto){
        var student = toStudent(dto);
        StudentResponseDto studentResponse=new StudentResponseDto(student.getFirstName(), student.getLastName(), student.getEmail());
        var savedStudent=studentRepository.save(student);
        return toStudentResponseDto(savedStudent);

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
