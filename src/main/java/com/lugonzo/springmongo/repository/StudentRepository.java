package com.lugonzo.springmongo.repository;

import com.lugonzo.springmongo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {

    //setting custom queries

    Optional<Student> findStudentByEmail(String email);
}
