package com.devsunnysingh.JPADemo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//<entity,type of the primaryKey>

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByFirstNameContaining(String firstName);
}
