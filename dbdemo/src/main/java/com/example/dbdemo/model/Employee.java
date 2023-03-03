package com.example.dbdemo.model;

import javax.persistence.*;

//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;

@Entity
@Table(name="Emp_TB")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long empId;
    @Column(name="FNAME")
    //@NotBlank(message ="First name should not be blank")
    //@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*" ,message="{Fistname.name.valid}")
    private String Fname;
    @Column(name="LNAME")
    private  String Lname;
    @Column(name="DEPT")
    private String dept;
    @Column(name="DESG")
    private String designation;
    @Column(name="SALARY")
    private double salary;

    public Employee(long empId, String fname, String lname, String dept, String designation, double salary) {
        this.empId = empId;
        this.Fname = fname;
        this.Lname = lname;
        this.dept = dept;
        this.designation = designation;
        this.salary = salary;
    }

    public Employee() {
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        this.Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        this.Lname = lname;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Employee ID=" + empId +
                ", Employee First Name='" + Fname + '\'' +
                ", Employee Last Name='" + Lname + '\'' +

                ", Employee Department =" + dept +
                ", Employee Designation ='" + designation + '\'' +
                ", Employee Salary ='" + salary + '\'' +
                '}';
    }
}
