package com.collegemgmt.College.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegemgmt.College.Management.System.model.CSEStudent;

public interface CSEStudentRepository extends JpaRepository<CSEStudent, Integer> {}