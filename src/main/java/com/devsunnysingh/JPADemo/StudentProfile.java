package com.devsunnysingh.JPADemo;

import jakarta.persistence.*;

@Entity
@Table(name = "studentprofile")
public class StudentProfile {
    @GeneratedValue
    @Id
    private Integer id;

    private String bio;

//    The name of the Student object
//    should be same as what we mention in @OneToOne annotation
//    in the Student class.
    @OneToOne
    @JoinColumn(
            name = "student_id"
    )
    private Student student;

    public StudentProfile() {
    }

    public StudentProfile(Integer id, String bio) {
        this.id = id;
        this.bio = bio;
    }

    public Integer getId() {
        return id;
    }

    public String getBio() {
        return bio;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
