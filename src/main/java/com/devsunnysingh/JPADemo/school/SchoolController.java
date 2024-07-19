package com.devsunnysingh.JPADemo.school;


import com.devsunnysingh.JPADemo.school.SchoolDto;
import com.devsunnysingh.JPADemo.school.SchoolService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

private final SchoolService schoolService;
    public SchoolController(SchoolService service) {

        this.schoolService=service;
    }

    @PostMapping("/schools")
    public SchoolDto createSchool(@RequestBody SchoolDto schoolDto) {
        return schoolService.createSchoolDetails(schoolDto);
    }


    @GetMapping("/listAllSchools")
    public List<SchoolDto> listAllSchools(){
  return schoolService.listAllSchools();
    }



}
