package com.collegemgmt.College.Management.System.dto;

public class StudentResponse {
    private Integer rno;
    private String name;
    private String branch;
    private Double cgpa;

    public StudentResponse() {}

    public StudentResponse(Integer rno, String name, String branch, Double cgpa) {
        this.rno = rno;
        this.name = name;
        this.branch = branch;
        this.cgpa = cgpa;
    }

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
