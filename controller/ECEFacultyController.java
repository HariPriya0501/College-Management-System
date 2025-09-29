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

import com.collegemgmt.College.Management.System.model.ECEFaculty;
import com.collegemgmt.College.Management.System.repository.ECEFacultyRepository;

@RestController
@RequestMapping("/ece/faculty")
@CrossOrigin("*")
public class ECEFacultyController {

    @Autowired
    private ECEFacultyRepository repo;

    @GetMapping
    public List<ECEFaculty> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ECEFaculty> getOne(@PathVariable Integer id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ECEFaculty create(@RequestBody ECEFaculty fac) {
        return repo.save(fac);
    }
}
