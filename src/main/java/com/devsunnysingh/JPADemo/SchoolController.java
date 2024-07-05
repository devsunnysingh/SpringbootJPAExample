package com.devsunnysingh.JPADemo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {
    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public School toSchool(SchoolDto schoolDto) {
        return new School(schoolDto.schoolName());
    }
    public SchoolDto toSchoolDto(School school){
        return new SchoolDto(school.getSchoolName());
    }
    @PostMapping("/schools")
    public SchoolDto createSchool(@RequestBody SchoolDto schoolDto) {
        var school= toSchool(schoolDto);
        System.out.println("School name is  "+ school.getSchoolName());

        var savedSchool=schoolRepository.save(school);
        return new SchoolDto(savedSchool.getSchoolName());
    }
    @GetMapping("/schoolsWithAllStudents")
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @GetMapping("/listAllSchools")
    public List<SchoolDto> listAllSchools(){
        return schoolRepository.findAll()
                .stream().map(this::toSchoolDto)
                .collect(Collectors.toList());
    }



}
