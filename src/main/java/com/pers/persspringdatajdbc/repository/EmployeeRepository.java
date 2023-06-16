package com.pers.persspringdatajdbc.repository;

import com.pers.persspringdatajdbc.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
