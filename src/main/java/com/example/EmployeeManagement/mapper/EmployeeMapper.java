package com.example.EmployeeManagement.mapper;

import com.example.EmployeeManagement.model.Employee;
import com.example.EmployeeManagement.dto.EmployeeDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

    public Employee toEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPosition(employeeDTO.getPosition());
        return employee;
    }

    public EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setPosition(employee.getPosition());
        return employeeDTO;
    }

    public List<Employee> toEmployeeEntity(List<EmployeeDTO> listEmployeeDto) {
        return listEmployeeDto.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<EmployeeDTO> toEmployeeDto(List<Employee> listEmployee) {
        return listEmployee.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Employee update(EmployeeDTO employeeDTO, Employee employee) {
        if (employeeDTO.getFirstName() != null) employee.setFirstName(employeeDTO.getFirstName());
        if (employeeDTO.getLastName() != null) employee.setLastName(employeeDTO.getLastName());
        if (employeeDTO.getEmail() != null) employee.setEmail(employeeDTO.getEmail());
        if (employeeDTO.getPosition() != null) employee.setPosition(employeeDTO.getPosition());
        return employee;
    }
}
