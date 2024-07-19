package com.devsunnysingh.JPADemo.school;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper=schoolMapper;
    }
    public SchoolDto createSchoolDetails(SchoolDto schoolDto){
        var school= schoolMapper.toSchool(schoolDto);
        var savedSchool=schoolRepository.save(school);
        return new SchoolDto(savedSchool.getSchoolName());

    }
    public List<SchoolDto> listAllSchools(){
        return schoolRepository.findAll()
                .stream()
                .map((school)->schoolMapper.toSchoolDto(school))
                .collect(Collectors.toList());
    }

}
