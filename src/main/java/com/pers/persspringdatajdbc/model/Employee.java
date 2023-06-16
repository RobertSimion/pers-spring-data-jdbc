package com.pers.persspringdatajdbc.model;

import lombok.Builder;
import lombok.ToString;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@AccessType(AccessType.Type.PROPERTY)
@ToString
@Table("EMPLOYEE_SPRING_DATA_JDBC")
public class Employee {
    @Id
    @Column("ID_EMPLOYEE")
    private Long id_employee;

    @Column("SALARY")
    private double salary;
    @Column("POSITION")
    private String position;

    @MappedCollection(idColumn = "ID_EMPLOYEE_DETAIL")
    private EmployeeDetail employeeDetail;

    public Employee(double salary, String position, EmployeeDetail employeeDetail) {
        this.salary = salary;
        this.position = position;
        this.employeeDetail = employeeDetail;
    }
}
