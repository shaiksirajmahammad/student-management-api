package com.apis.LearningApis.Controller;

import com.apis.LearningApis.DTO.Student;
import com.apis.LearningApis.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class StudentController {
    @Autowired
    StudentService service;
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(service.getAllStudents());
    }
    @PostMapping("/students")
    public ResponseEntity<Student>addStudent(@RequestBody @Valid Student obj){
        return ResponseEntity.status(HttpStatus.CREATED).body( service.addStudent(obj));
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<Student>getStudentbyid(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getStudent(id));
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void>deleteStudentbyid(@PathVariable int id){
        service.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/students/{id}")
    public ResponseEntity<Student>put(@PathVariable int id,@RequestBody @Valid Student obj){
        return ResponseEntity.status(HttpStatus.OK).body(service.put(id,obj));
    }
    @PatchMapping("/students/{id}")
    public ResponseEntity<Student>update(@PathVariable int id, @RequestBody Map<Object,Object>hash){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(id,hash));
    }

}
