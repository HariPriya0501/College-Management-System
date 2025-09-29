package com.collegemgmt.College.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.collegemgmt.College.Management.System.model.ITStudent;

public interface ITStudentRepository extends JpaRepository<ITStudent, Integer> {
}