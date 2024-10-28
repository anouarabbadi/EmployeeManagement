package com.example.EmployeeManagement.rest;

import com.example.EmployeeManagement.service.EmployeeService;
import com.example.EmployeeManagement.dto.EmployeeDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/getall")
    public List<EmployeeDTO> getAll() {
        return employeeService.findAll();
    }

    @GetMapping(path = "/get/{id}")
    public EmployeeDTO getById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @PostMapping(path = "/add")
    public void addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.save(employeeDTO);
    }

    @PutMapping(path = "/update")
    public void updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.update(employeeDTO);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteById(id);
    }
}