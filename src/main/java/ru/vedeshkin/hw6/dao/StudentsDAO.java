package ru.vedeshkin.hw6.dao;

import org.springframework.stereotype.Repository;
import ru.vedeshkin.hw6.entity.Student;

import java.util.List;

@Repository
public interface StudentsDAO {

    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudent(int id);

    void deleteStudent(int id);

}
