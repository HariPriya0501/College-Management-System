package com.collegemgmt.College.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collegemgmt.College.Management.System.model.ECEStudent;

public interface ECEStudentRepository extends JpaRepository<ECEStudent, Integer> {
}