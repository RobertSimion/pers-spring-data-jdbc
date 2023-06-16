package com.pers.persspringdatajdbc;

import com.pers.persspringdatajdbc.model.Payroll;
import com.pers.persspringdatajdbc.service.EmployeeDetailsService;
import com.pers.persspringdatajdbc.service.EmployeeService;
import com.pers.persspringdatajdbc.service.PayrollService;
import com.pers.persspringdatajdbc.util.PayrollGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

@SpringBootApplication
public class PersSpringDataJdbcApplication implements CommandLineRunner {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(PersSpringDataJdbcApplication.class);

    private static List<Payroll> payrolls;

    private static Duration elapsedTime = null;

    @Value(value = "${iterations}")
    private String[] iterations;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeDetailsService employeeDetailsService;

    @Autowired
    private PayrollService payrollService;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
        for(String iteration: iterations) {
            if(Integer.parseInt(iteration) == 5000) {
                LOGGER.info("ITERATION START FOR : " + iteration);
                truncateAll();

                //init
//        payrolls = PayrollGenerator.setupPayrollLink(Integer.parseInt(iterations));

                //insert each
//        insertEach();

                //truncate
//        truncateAll();

                payrolls = PayrollGenerator.setupPayrollLink(Integer.parseInt(iteration));

                //insert saveAll
                insertAll();

                truncateAll();


                payrolls = PayrollGenerator.setupPayrollLink(Integer.parseInt(iteration));

                //insert saveAll
                insertAll();

                truncateAll();
                payrolls = PayrollGenerator.setupPayrollLink(Integer.parseInt(iteration));


                insertAll();
                //update
                update();

                //select All
                selectAll();

                LOGGER.info("ITERATION END FOR : " + iteration);
                //truncateDeleteEach
//        truncateEach();
            }
        }
    }

    private void selectAll() {
        Instant start = Instant.now();
        payrollService.findAll();
        Instant end = Instant.now();
        elapsedTime = Duration.between(start, end);
        LOGGER.info("Select all.. " + elapsedTime.toMillis());
    }

    private void update() {
        Instant start = Instant.now();
        List<Long> ids = payrollService.getIds();
        for (Long id : ids) {
            payrollService.updatePayroll(id);
        }
        Instant end = Instant.now();
        elapsedTime = Duration.between(start, end);
        LOGGER.info("Update " + elapsedTime.toMillis());
    }

    private void insertAll() {
        Instant start = Instant.now();
        payrollService.saveAll(payrolls);
        Instant end = Instant.now();
        elapsedTime = Duration.between(start, end);
        LOGGER.info("Insert saveAll " + elapsedTime.toMillis());
    }

    private void insertEach() {
        Instant start = Instant.now();
        for (Payroll payroll : payrolls) {
            payrollService.save(payroll);
        }
        Instant end = Instant.now();
        elapsedTime = Duration.between(start, end);
        LOGGER.info("Insert each  " + elapsedTime.toMillis());
    }

    private void truncateAll() {
        Instant start = Instant.now();
        payrollService.deleteAll();
        Instant end = Instant.now();
        elapsedTime = Duration.between(start, end);
        LOGGER.info("Truncate deleteAll " + elapsedTime.toMillis());
    }

    private void truncateEach() {
        Instant start = Instant.now();
        for (Payroll payroll : payrolls) {
            payrollService.delete(payroll);
        }
        Instant end = Instant.now();
        elapsedTime = Duration.between(start, end);
        LOGGER.info("Truncate each " + elapsedTime.toMillis());
    }

    public static void main(String[] args) {
        SpringApplication.run(PersSpringDataJdbcApplication.class, args);
    }
}
