package com.mycompany.myapp.projmngrefact.application.emp;

import java.time.LocalDate;

import com.mycompany.myapp.projmngrefact.adapter.emp.EmpNumCounterRepositoryJdbc;

public class EmpNumGenerator {

    final EmpNumCounterRepositoryJdbc empNumCounterRepositoryJdbc;

    public EmpNumGenerator(EmpNumCounterRepositoryJdbc empNumCounterRepositoryJdbc) {
        this.empNumCounterRepositoryJdbc = empNumCounterRepositoryJdbc;
    }

    public String generateEmpNum(Long tenantId) {
        return generateEmpNumByYear(tenantId, LocalDate.now().getYear());
    }

    private String generateEmpNumByYear(Long tenantId, int year) {
        int maxNum = empNumCounterRepositoryJdbc.increaseMaxNumByYear(tenantId, year);
        return String.format("%04d%08d", year, maxNum);
    }

}
