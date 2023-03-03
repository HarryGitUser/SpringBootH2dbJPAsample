package com.example.dbdemo.dto;

import com.example.dbdemo.model.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmpRequestDTO {
    private String Fname;
    private String Lname;
    private String dept;
    private  String designation;
    private double salary;

    public EmpRequestDTO(Employee employee){
//        this.setEmpId(employee.getEmpId());
        this.setFname(employee.getFname());
        this.setLname(employee.getLname());
        this.setDept(employee.getDept());
        this.setDesignation(employee.getDesignation());
        this.setSalary(employee.getSalary());
    }

}
