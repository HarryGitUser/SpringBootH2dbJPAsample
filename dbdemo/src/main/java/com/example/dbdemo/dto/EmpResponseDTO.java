package com.example.dbdemo.dto;

import com.example.dbdemo.model.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class EmpResponseDTO {
    private long empId;
    private String fName;
    private String lName;
    private String dept;
    private  String designation;
    private double salary;
    public EmpResponseDTO(Employee employee){
        this.setEmpId(employee.getEmpId());
        this.setFName(employee.getFname());
        this.setLName(employee.getLname());
        this.setDept(employee.getDept());
        this.setDesignation(employee.getDesignation());
        this.setSalary(employee.getSalary());
    }
}
