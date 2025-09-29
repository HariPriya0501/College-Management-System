package com.collegemgmt.College.Management.System.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cse_std")
public class CSEStudent {

    @Id
    private Integer rno;

    private String name;

    private String branch;

    private Integer cgpa;

    // getters/setters
    public Integer getRno() {
        return rno;
    }
    public void setRno(Integer rno) {
        this.rno = rno;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Integer getCgpa() {
        return cgpa;
    }
    public void setCgpa(Integer cgpa) {
        this.cgpa = cgpa;
    }
}