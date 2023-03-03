package com.example.dbdemo.service;

import com.example.dbdemo.dto.EmpRequestDTO;
import com.example.dbdemo.dto.EmpResponseDTO;
import com.example.dbdemo.exception.EmpNotFoundException;
import com.example.dbdemo.model.Employee;
import com.example.dbdemo.repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpRepo empRepo;
    @Override
    public List<EmpResponseDTO> getAllEmployees() {
        List<Employee> employeeList = empRepo.findAll();
        List<EmpResponseDTO> empResponseDTOList = new ArrayList<EmpResponseDTO>();
            empResponseDTOList =  employeeList.stream().map((employee)->{
            //EmpResponseDTO empResponseDTO = new EmpResponseDTO();
            EmpResponseDTO empResponseDTO = new EmpResponseDTO(employee);
            return empResponseDTO;
        }).collect(Collectors.toList());
        return empResponseDTOList;
    }

    @Override
    public EmpResponseDTO addEmployee(EmpRequestDTO empRequestDTO) {
        Employee employee = new Employee();
            employee.setFname(empRequestDTO.getFname());
            employee.setLname(empRequestDTO.getLname());
            employee.setDept(empRequestDTO.getDept());
            employee.setDesignation(empRequestDTO.getDesignation());
            employee.setSalary(empRequestDTO.getSalary());

        Employee savedEmployee =  empRepo.save(employee);
            EmpResponseDTO empResponseDTO = new EmpResponseDTO(savedEmployee);
            //EmpResponseDTO empResponseDTO = new EmpResponseDTO();
            //empResponseDTO.setBookId(savedEmployee.getBookId());
            //empResponseDTO.setBookName(savedEmployee.getBookName());
            //empResponseDTO.setNoOfPages(savedEmployee.getNoOfPages());
            //empResponseDTO.setPublicationName(savedEmployee.getPublicationName());
            //empResponseDTO.setAuthorName(savedEmployee.getAuthorName());
        return empResponseDTO;
    }

    @Override
    public EmpResponseDTO getEmployee(int empId) {
        Optional<Employee> empOptional = empRepo.findById(empId);

        if(empOptional.isPresent()){
            Employee searchedEmployee =  empOptional.get();
            EmpResponseDTO empResponseDTO = new EmpResponseDTO(searchedEmployee);
/*          EmpResponseDTO empResponseDTO = new EmpResponseDTO();
            empResponseDTO.setBookId(searchedEmployee.getBookId());
            empResponseDTO.setBookName(searchedEmployee.getBookName());
            empResponseDTO.setNoOfPages(searchedEmployee.getNoOfPages());
            empResponseDTO.setPublicationName(searchedEmployee.getPublicationName());
            empResponseDTO.setAuthorName(searchedEmployee.getAuthorName()); */
            return empResponseDTO;
        }else{
            throw new EmpNotFoundException("The Book with ID : "+empId + " is not present.");
        }
        //return null;
    }

    @Override
    public EmpResponseDTO updateEmployee(int bookId, EmpRequestDTO empRequestDTO) {

        Optional<Employee> empOptional = empRepo.findById(bookId);
        if(empOptional.isPresent()){
            //If present then update will happen
            Employee searchedEmployee = empOptional.get();
                searchedEmployee.setFname(empRequestDTO.getFname());
                searchedEmployee.setLname(empRequestDTO.getLname());
                searchedEmployee.setDept(empRequestDTO.getDept());
                searchedEmployee.setDesignation(empRequestDTO.getDesignation());
                searchedEmployee.setSalary(empRequestDTO.getSalary());

            empRepo.flush();
            EmpResponseDTO empResponseDTO = new EmpResponseDTO(searchedEmployee);
            /*EmpResponseDTO empResponseDTO = new EmpResponseDTO();
            empResponseDTO.setBookId(searchedEmployee.getBookId());
            empResponseDTO.setBookName(searchedEmployee.getBookName());
            empResponseDTO.setNoOfPages(searchedEmployee.getNoOfPages());
            empResponseDTO.setPublicationName(searchedEmployee.getPublicationName());
            empResponseDTO.setAuthorName(searchedEmployee.getAuthorName());*/
            return empResponseDTO;
        }else{
            //A new emp will be created
            Employee newEmployee = new Employee();
                    newEmployee.setFname(empRequestDTO.getFname());
                    newEmployee.setLname(empRequestDTO.getLname());
                    newEmployee.setDept(empRequestDTO.getDept());
                    newEmployee.setDesignation(empRequestDTO.getDesignation());
                    newEmployee.setSalary(empRequestDTO.getSalary());
            Employee savedEmployee = empRepo.save(newEmployee);

            EmpResponseDTO empResponseDTO = new EmpResponseDTO(savedEmployee);
/*          EmpResponseDTO empResponseDTO = new EmpResponseDTO();
            empResponseDTO.setBookId(savedEmployee.getBookId());
            empResponseDTO.setBookName(savedEmployee.getBookName());
            empResponseDTO.setNoOfPages(savedEmployee.getNoOfPages());
            empResponseDTO.setPublicationName(savedEmployee.getPublicationName());
            empResponseDTO.setAuthorName(savedEmployee.getAuthorName());*/
            return empResponseDTO;
        }
        //return null;
    }

    @Override
    public EmpResponseDTO deleteEmployeeById(int empId) {
        Optional<Employee> empOptional = empRepo.findById(empId);
        if(empOptional.isPresent()){
            Employee deletedEmployee = empOptional.get();
            empRepo.delete(deletedEmployee);
            EmpResponseDTO empResponseDTO = new EmpResponseDTO(deletedEmployee);
            return empResponseDTO;
        }else{
            throw new EmpNotFoundException("Employee having ID : "+empId+ " not present in DB");
        }

    }
}
