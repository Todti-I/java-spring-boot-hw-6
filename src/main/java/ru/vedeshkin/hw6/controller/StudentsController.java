package ru.vedeshkin.hw6.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vedeshkin.hw6.entity.Student;
import ru.vedeshkin.hw6.model.Response;
import ru.vedeshkin.hw6.model.ResponseCode;
import ru.vedeshkin.hw6.service.StudentService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/students")
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @GetMapping()
    public Response<List<Student>> allStudents() {
        Response.ResponseBuilder<List<Student>> responseBuilder = Response.builder();
        try {
            List<Student> allStudents = studentService.getAllStudents();
            responseBuilder.code(ResponseCode.SUCCESS);
            responseBuilder.data(allStudents);
        } catch (Exception exception) {
            log.error("GET /api/students: {}", exception.getMessage());
            responseBuilder.code(ResponseCode.FAILED);
        }
        return responseBuilder.build();
    }

    @GetMapping("/{id}")
    public Response<Student> getStudent(@PathVariable("id") int id) {
        Response.ResponseBuilder<Student> responseBuilder = Response.builder();
        try {
            Student student = studentService.getStudent(id);
            responseBuilder.code(ResponseCode.SUCCESS);
            responseBuilder.data(student);
        } catch (Exception exception) {
            log.error("GET /api/students/{}: {}", id, exception.getMessage());
            responseBuilder.code(ResponseCode.FAILED);
        }
        return responseBuilder.build();
    }

    @PostMapping()
    public Response<Student> saveStudent(@RequestBody Student student) {
        Response.ResponseBuilder<Student> responseBuilder = Response.builder();
        try {
            Student updatedStudent = studentService.saveStudent(student);
            responseBuilder.code(ResponseCode.SUCCESS);
            responseBuilder.data(updatedStudent);
        } catch (Exception exception) {
            log.error("POST /api/students: {}", exception.getMessage());
            responseBuilder.code(ResponseCode.FAILED);
        }
        return responseBuilder.build();
    }

    @PutMapping()
    public Response<Student> updateStudent(@RequestBody Student student) {
        Response.ResponseBuilder<Student> responseBuilder = Response.builder();
        try {
            Student updatedStudent = studentService.saveStudent(student);
            responseBuilder.code(ResponseCode.SUCCESS);
            responseBuilder.data(updatedStudent);
        } catch (Exception exception) {
            log.error("PUT /api/students: {}", exception.getMessage());
            responseBuilder.code(ResponseCode.FAILED);
        }
        return responseBuilder.build();
    }

    @DeleteMapping("/{id}")
    public Response<Object> deleteStudent(@PathVariable("id") int id) {
        Response.ResponseBuilder<Object> responseBuilder = Response.builder();
        try {
            studentService.deleteStudent(id);
            responseBuilder.code(ResponseCode.SUCCESS);
        } catch (Exception exception) {
            log.error("DELETE /api/students/{}: {}", id, exception.getMessage());
            responseBuilder.code(ResponseCode.FAILED);
        }
        return responseBuilder.build();
    }

}
