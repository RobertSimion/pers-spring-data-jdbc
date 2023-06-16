package com.pers.persspringdatajdbc.repository;

import com.pers.persspringdatajdbc.model.Payroll;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayrollRepository extends CrudRepository<Payroll, Long> {
//    MYSQL & oracle
    @Modifying
    @Query("update payroll_spring_data_jdbc set STATUS='test' where ID_PAYROLL=:idPayroll")
    void updateMysql(Long idPayroll);

    @Query("select ID_PAYROLL from payroll_spring_data_jdbc")
    List<Long> getIdsMySql();

    //POSTGRES & MSSQL
//    @Modifying
//    @Query("update \"PAYROLL_SPRING_DATA_JDBC\" set \"STATUS\"='test' where \"ID_PAYROLL\"=:idPayroll")
//    void updateMysql(Long idPayroll);
//
//    @Query("select \"ID_PAYROLL\" from \"PAYROLL_SPRING_DATA_JDBC\"")
//    List<Long> getIdsMySql();
}
