package com.example.dbdemo.service;

import com.example.dbdemo.dto.EmpRequestDTO;
import com.example.dbdemo.dto.EmpResponseDTO;

import java.util.List;

public interface EmpService {
    List<EmpResponseDTO> getAllEmployees();

    EmpResponseDTO addEmployee(EmpRequestDTO empRequestDTO);

    EmpResponseDTO getEmployee(int empId);

    EmpResponseDTO updateEmployee(int empId, EmpRequestDTO empRequestDTO);

    EmpResponseDTO deleteEmployeeById(int empId);
}
