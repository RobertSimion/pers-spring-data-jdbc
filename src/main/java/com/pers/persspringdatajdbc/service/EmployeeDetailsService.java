package com.pers.persspringdatajdbc.service;

import com.pers.persspringdatajdbc.model.EmployeeDetail;
import com.pers.persspringdatajdbc.repository.EmployeeDetailsRepository;
import com.pers.persspringdatajdbc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDetailsService {

    @Autowired
    private Environment environment;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDetail save(EmployeeDetail employeeDetails) {
        return employeeDetailsRepository.save(employeeDetails);
    }

    public List<EmployeeDetail> findAll() {
        return (List<EmployeeDetail>) employeeDetailsRepository.findAll();
    }

    public EmployeeDetail findById(Long id) {
        return employeeDetailsRepository.findById(id).orElse(null);
    }

    public void delete(EmployeeDetail employeeDetails) {
        employeeDetailsRepository.delete(employeeDetails);
    }

    public void deleteAll() {
        employeeDetailsRepository.deleteAll();
    }

    public void deleteById(Long id) {
        employeeDetailsRepository.deleteById(id);
    }

    public void update(String replace, Long id) {
        employeeDetailsRepository.update(replace, id);
    }
}
