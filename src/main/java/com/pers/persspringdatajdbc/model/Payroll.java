package com.pers.persspringdatajdbc.model;

import lombok.Builder;
import lombok.ToString;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Table("PAYROLL_SPRING_DATA_JDBC")
@ToString
@AccessType(AccessType.Type.PROPERTY)
public class Payroll {
    @Id
    @Column("ID_PAYROLL")
    private Long id;

    @Column("STATUS")
    private String status;
    @Column("BUDGET")
    private double budget;

    @MappedCollection(keyColumn = "ID_EMPLOYEE", idColumn = "ID_EMPLOYEE")
    private Set<Employee> employees;

    public Payroll(String status, double budget, Set<Employee> employees) {
        this.status = status;
        this.budget = budget;
        this.employees = employees;
    }
}
