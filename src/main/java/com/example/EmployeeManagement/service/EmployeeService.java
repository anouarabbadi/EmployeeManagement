package com.example.EmployeeManagement.service;


import com.example.EmployeeManagement.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> findAll();
    EmployeeDTO findById(Long id);
    void save(EmployeeDTO employeeDTO);
    void update(EmployeeDTO employeeDTO);
    void deleteById(Long id);
}