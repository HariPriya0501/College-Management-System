package com.collegemgmt.College.Management.System.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collegemgmt.College.Management.System.model.CSEStudent;
import com.collegemgmt.College.Management.System.repository.CSEStudentRepository;

@RestController
@RequestMapping("/cse/students")
@CrossOrigin("*")
public class CSEStudentController {

    @Autowired
    private CSEStudentRepository repo;

    @PostMapping
    public CSEStudent addStudent(@RequestBody CSEStudent student) {
        return repo.save(student);
    }

    @GetMapping
    public List<CSEStudent> getAllStudents() {
        return repo.findAll();
    }

    @GetMapping("/{rno}")
    public ResponseEntity<CSEStudent> getStudentByRno(@PathVariable Integer rno) {
        Optional<CSEStudent> student = repo.findById(rno);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{rno}")
    public ResponseEntity<CSEStudent> updateStudent(@PathVariable Integer rno, @RequestBody CSEStudent studentDetails) {
        Optional<CSEStudent> optionalStudent = repo.findById(rno);
        if (optionalStudent.isPresent()) {
            CSEStudent student = optionalStudent.get();
            student.setName(studentDetails.getName());
            student.setBranch(studentDetails.getBranch());
            student.setCgpa(studentDetails.getCgpa());
            return ResponseEntity.ok(repo.save(student));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{rno}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer rno) {
        if (repo.existsById(rno)) {
            repo.deleteById(rno);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
