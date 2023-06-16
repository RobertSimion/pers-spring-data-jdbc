package com.pers.persspringdatajdbc.service;

import com.pers.persspringdatajdbc.model.Payroll;
import com.pers.persspringdatajdbc.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    public void save(Payroll payroll) {
        payrollRepository.save(payroll);
    }

    public void saveAll(List<Payroll> payrolls) {
        payrollRepository.saveAll(payrolls);
    }

    public List<Payroll> findAll() {
        return (List<Payroll>) payrollRepository.findAll();
    }

    public Optional<Payroll> findById(Long id) {
        return payrollRepository.findById(id);
    }

    public void delete(Payroll payroll) {
        payrollRepository.delete(payroll);
    }

    public void deleteAll() {
        payrollRepository.deleteAll();
    }


    public void deleteById(Long id) {
        payrollRepository.deleteById(id);
    }

    public void updatePayroll(Long idPayroll) {
        payrollRepository.updateMysql(idPayroll);
    }

    public List<Long> getIds() {
        return payrollRepository.getIdsMySql();
    }
}