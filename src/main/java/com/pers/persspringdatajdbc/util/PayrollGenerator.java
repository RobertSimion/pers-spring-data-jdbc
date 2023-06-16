package com.pers.persspringdatajdbc.util;

import com.pers.persspringdatajdbc.model.Employee;
import com.pers.persspringdatajdbc.model.EmployeeDetail;
import com.pers.persspringdatajdbc.model.Payroll;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class PayrollGenerator {

    public static List<Payroll> setupPayrollLink(int iterations) {
        List<Payroll> payrolls = new LinkedList<>();
        for (int i = 0; i < iterations; i++) {
            EmployeeDetail employeeDetail = new EmployeeDetail("firstname" + i, "lastname" + i, i, "address" + i);
            Employee employee = new Employee(i*5, "position" + i, employeeDetail);
            Payroll payroll = new Payroll("status" + i, i, new HashSet<>(Collections.singletonList(employee)));
            payrolls.add(payroll);
        }

        return payrolls;
    }
}