package com.utkarsh.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.utkarsh.studentmanagement.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
