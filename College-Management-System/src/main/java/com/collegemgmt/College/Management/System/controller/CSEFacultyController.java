package com.collegemgmt.College.Management.System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collegemgmt.College.Management.System.model.CSEFaculty;
import com.collegemgmt.College.Management.System.repository.CSEFacultyRepository;

@RestController
@RequestMapping("/cse/faculty")
@CrossOrigin("*")
public class CSEFacultyController {

    @Autowired
    private CSEFacultyRepository repo;

    @GetMapping
    public List<CSEFaculty> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CSEFaculty> getOne(@PathVariable Integer id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CSEFaculty create(@RequestBody CSEFaculty fac) {
        return repo.save(fac);
    }
}