package com.collegemgmt.College.Management.System.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ece_std")
public class ECEStudent {

    @Id
    private Integer rno; 

    private String name;

    private String branch;

    private Double cgpa;

   
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

    public Double getCgpa() {
        return cgpa;
    }
    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }
}