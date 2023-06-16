package com.pers.persspringdatajdbc.service;

import com.pers.persspringdatajdbc.model.Employee;
import com.pers.persspringdatajdbc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    public void deleteAll() {
        employeeRepository.deleteAll();
    }


    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

//    public Employee update(Long employeeId, Employee employee) {
//        Employee existingEmployee = findById(employeeId);
//
//        existingEmployee.setSalary(employee.getSalary());
//        existingEmployee.setPosition(employee.getPosition());
//
//        return employeeRepository.save(existingEmployee);
//    }
}