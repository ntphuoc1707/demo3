package com.example.demo3.repositories;

import com.example.demo3.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * com.example.demo3.repositories;
 * Created by Phuoc -19127520
 * Date 24/04/2022 - 10:40 CH
 * Description: ...
 */
public interface StudentRepository extends CrudRepository<Student, Long> {
}
