package com.devsunnysingh.JPADemo.student;

import com.devsunnysingh.JPADemo.student.StudentDTO;
import com.devsunnysingh.JPADemo.student.StudentMapper;
import com.devsunnysingh.JPADemo.student.StudentRepository;
import com.devsunnysingh.JPADemo.student.StudentResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }
    public StudentResponseDto saveStudent(StudentDTO dto){
        var student = studentMapper.toStudent(dto);
        StudentResponseDto studentResponse=new StudentResponseDto(student.getFirstName(), student.getLastName(), student.getEmail());
        var savedStudent=studentRepository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);

    }
    public List<StudentResponseDto> findAllStudents(){
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }
    public StudentResponseDto findStudentById(Integer id){
        return studentRepository.findById(id)
                .map(studentMapper::toStudentResponseDto).
                orElse(null);
    }
    public List<StudentResponseDto> findAllStudentsByFirstNameContaining(String firstName){
        return studentRepository.findAllByFirstNameContaining(firstName)
                .stream()
                .map(student -> studentMapper.toStudentResponseDto(student))
                .collect(Collectors.toList());
    }
    public String deleteStudentRecordById(Integer Id){
        studentRepository.deleteById(Id);
        return "Student record deleted";

    }
}
