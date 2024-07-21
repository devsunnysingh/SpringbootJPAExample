package com.devsunnysingh.JPADemo.student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {
    StudentService studentService;

    public StudentController(StudentService service) {
        this.studentService=service;
    }

    @PostMapping("/students")
    public StudentResponseDto post(@Valid @RequestBody StudentDTO dto){
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

    @ExceptionHandler
    public ResponseEntity<?> handleMethodArgumentsNotValidException(MethodArgumentNotValidException e){
//    string->will hold field name string->will hold message name
        var errors=new HashMap<String,String>();
        e.getBindingResult().getAllErrors()
                .forEach(error->{
                    var fieldName=((FieldError)error).getField();
                    var errorMessage=((FieldError)error).getDefaultMessage();
                    errors.put(fieldName,errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
