package com.collegemgmt.College.Management.System.controller;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collegemgmt.College.Management.System.dto.StudentRequest;
import com.collegemgmt.College.Management.System.dto.StudentResponse;
import com.collegemgmt.College.Management.System.model.CSEStudent;
import com.collegemgmt.College.Management.System.model.ECEStudent;
import com.collegemgmt.College.Management.System.model.ITStudent;
import com.collegemgmt.College.Management.System.repository.CSEStudentRepository;
import com.collegemgmt.College.Management.System.repository.ECEStudentRepository;
import com.collegemgmt.College.Management.System.repository.ITStudentRepository;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private CSEStudentRepository cseRepo;

    @Autowired
    private ECEStudentRepository eceRepo;

    @Autowired
    private ITStudentRepository itRepo;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody StudentRequest req) {
        if (req == null || req.getBranch() == null || req.getRno() == null || req.getName() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("rno, name and branch are required");
        }
        String branch = req.getBranch().toUpperCase(Locale.ROOT).trim();
        switch (branch) {
            case "CSE": {
                if (cseRepo.existsById(req.getRno())) {
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("CSE student with rno already exists");
                }
                CSEStudent s = new CSEStudent();
                s.setRno(req.getRno());
                s.setName(req.getName());
                s.setBranch("CSE");
                // CSE uses Integer cgpa; convert if provided
                if (req.getCgpa() != null) {
                    s.setCgpa(req.getCgpa().intValue());
                }
                CSEStudent saved = cseRepo.save(s);
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(new StudentResponse(saved.getRno(), saved.getName(), saved.getBranch(), saved.getCgpa() == null ? null : saved.getCgpa().doubleValue()));
            }
            case "ECE": {
                if (eceRepo.existsById(req.getRno())) {
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("ECE student with rno already exists");
                }
                ECEStudent s = new ECEStudent();
                s.setRno(req.getRno());
                s.setName(req.getName());
                s.setBranch("ECE");
                if (req.getCgpa() != null) {
                    s.setCgpa(req.getCgpa());
                }
                ECEStudent saved = eceRepo.save(s);
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(new StudentResponse(saved.getRno(), saved.getName(), saved.getBranch(), saved.getCgpa()));
            }
            case "IT": {
                if (itRepo.existsById(req.getRno())) {
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("IT student with rno already exists");
                }
                ITStudent s = new ITStudent();
                s.setRno(req.getRno());
                s.setName(req.getName());
                s.setBranch("IT");
                if (req.getCgpa() != null) {
                    s.setCgpa(req.getCgpa());
                }
                ITStudent saved = itRepo.save(s);
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(new StudentResponse(saved.getRno(), saved.getName(), saved.getBranch(), saved.getCgpa()));
            }
            default:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid branch. Use one of: CSE, ECE, IT");
        }
    }

    @GetMapping
    public ResponseEntity<?> listByBranch(@RequestParam(name = "branch", required = true) String branchParam) {
        if (branchParam == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("branch query parameter is required");
        }
        String branch = branchParam.toUpperCase(Locale.ROOT).trim();
        switch (branch) {
            case "CSE":
                List<StudentResponse> cse = cseRepo.findAll().stream()
                    .map(s -> new StudentResponse(s.getRno(), s.getName(), s.getBranch(), s.getCgpa() == null ? null : s.getCgpa().doubleValue()))
                    .collect(Collectors.toList());
                return ResponseEntity.ok(cse);
            case "ECE":
                List<StudentResponse> ece = eceRepo.findAll().stream()
                    .map(s -> new StudentResponse(s.getRno(), s.getName(), s.getBranch(), s.getCgpa()))
                    .collect(Collectors.toList());
                return ResponseEntity.ok(ece);
            case "IT":
                List<StudentResponse> it = itRepo.findAll().stream()
                    .map(s -> new StudentResponse(s.getRno(), s.getName(), s.getBranch(), s.getCgpa()))
                    .collect(Collectors.toList());
                return ResponseEntity.ok(it);
            default:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid branch. Use one of: CSE, ECE, IT");
        }
    }
}
