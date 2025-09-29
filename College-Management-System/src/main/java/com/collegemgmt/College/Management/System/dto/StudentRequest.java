package com.collegemgmt.College.Management.System.dto;

public class StudentRequest {
    private Integer rno;
    private String name;
    private String branch; // expected values: CSE, ECE, IT (case-insensitive)
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
