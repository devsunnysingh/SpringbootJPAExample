package com.devsunnysingh.JPADemo.school;

import com.devsunnysingh.JPADemo.student.Student;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "school")
public class School {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(
            name = "school_name",
            length = 100
    )
    private String schoolName;
    @OneToMany(mappedBy = "school")
    @JsonManagedReference
    private List<Student> students;

    public School() {

    }
    public School(Integer id, String schoolName) {
        this.id = id;
        this.schoolName = schoolName;
    }

    public School(String name) {
        this.schoolName = name;
    }

    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getSchoolName() {
        return schoolName;
    }
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
