package com.pers.persspringdatajdbc.repository;

import com.pers.persspringdatajdbc.model.EmployeeDetail;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDetailsRepository extends CrudRepository<EmployeeDetail, Long> {
    @Modifying
    @Query("UPDATE employee_detail_spring_data_jdbc set first_name = :replace WHERE id_employee_detail = :id")
    void update(String replace, Long id);

//    @Modifying
//    @Query("delete where employee_detail = ?1")
//    void deleteById(Long id);


}
