package com.example.EmployeeManagement.service.impl;

import com.example.EmployeeManagement.mapper.EmployeeMapper;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import com.example.EmployeeManagement.service.EmployeeService;
import com.example.EmployeeManagement.dto.EmployeeDTO;
import com.example.EmployeeManagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeImplService implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDTO> findAll() {
        return employeeMapper.toEmployeeDto(employeeRepository.findAll());
    }

    @Override
    public EmployeeDTO findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        return employee != null ? employeeMapper.toDTO(employee) : null;
    }

    @Override
    public void save(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);
        employeeRepository.save(employee);
    }

    @Override
    public void update(EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(employeeDTO.getId()).orElse(null);
        if (employee != null) {
            employee = employeeMapper.update(employeeDTO, employee);
            employeeRepository.save(employee);
        }
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}