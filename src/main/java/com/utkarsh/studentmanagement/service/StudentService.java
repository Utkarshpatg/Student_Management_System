package com.utkarsh.studentmanagement.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.utkarsh.studentmanagement.entity.Student;
import com.utkarsh.studentmanagement.repository.StudentRepository;
import com.utkarsh.studentmanagement.exception.ResourceNotFoundException;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student createStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student student = getStudentById(id);
        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());
        student.setCourse(updatedStudent.getCourse());
        return repository.save(student);
    }

    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        repository.delete(student);
    }
}
