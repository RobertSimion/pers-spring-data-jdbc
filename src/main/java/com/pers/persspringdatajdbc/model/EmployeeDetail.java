package com.pers.persspringdatajdbc.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("EMPLOYEE_DETAIL_SPRING_DATA_JDBC")
@ToString
@AccessType(AccessType.Type.PROPERTY)
public class EmployeeDetail {

    @Id
    @Column("ID_EMPLOYEE_DETAIL")
    private Long idEmployeeDetail;
    @Column("FIRST_NAME")
    private String firstname;
    @Column("LAST_NAME")
    private String lastname;
    @Column("SENIORITY")
    private int seniority;
    @Column("ADDRESS")
    private String address;

    public EmployeeDetail(String firstname, String lastname, int seniority, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.seniority = seniority;
        this.address = address;
    }

}
