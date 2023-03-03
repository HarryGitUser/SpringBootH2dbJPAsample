package com.example.dbdemo.controller;

import com.example.dbdemo.dto.EmpRequestDTO;
import com.example.dbdemo.dto.EmpResponseDTO;
import com.example.dbdemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class EmpController {

    private static final Log LOGGER = LogFactory.getLog(EmpController.class);

    @Autowired
    private EmpService empService;
    @GetMapping("/employees")
     public ResponseEntity<List<EmpResponseDTO>> getAllEmployees(){
        List<EmpResponseDTO> empList = empService.getAllEmployees();
        if(empList.size()>0){
            return new ResponseEntity<List<EmpResponseDTO>>(empList, HttpStatus.OK);
        }else{
            LOGGER.info("There is no employees available");
            return new ResponseEntity<List<EmpResponseDTO>>(empList, HttpStatus.NO_CONTENT);
        }
    }
    @PostMapping("/employees")
    public EmpResponseDTO addEmployee(@RequestBody EmpRequestDTO empRequestDTO){
        return empService.addEmployee(empRequestDTO);
    }
    @GetMapping("/employees/{empId}")
    public EmpResponseDTO getEmployee(@PathVariable int empId){
        return empService.getEmployee(empId);
    }
    @PutMapping("/employees/{empId}")
    public EmpResponseDTO updateEmployee(@PathVariable int empId, @RequestBody EmpRequestDTO empRequestDTO){
        return empService.updateEmployee(empId, empRequestDTO);
    }
    @DeleteMapping("/employees/{empId}")
    public EmpResponseDTO deleteEmployeeById(@PathVariable int empId){
        return empService.deleteEmployeeById(empId);
    }
}
