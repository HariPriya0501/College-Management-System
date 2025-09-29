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

import com.collegemgmt.College.Management.System.model.ITFaculty;
import com.collegemgmt.College.Management.System.repository.ITFacultyRepository;

@RestController
@RequestMapping("/it/faculty")
@CrossOrigin("*")
public class ITFacultyController {

    @Autowired
    private ITFacultyRepository repo;

    @GetMapping
    public List<ITFaculty> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ITFaculty> getOne(@PathVariable Integer id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ITFaculty create(@RequestBody ITFaculty fac) {
        return repo.save(fac);
    }
}