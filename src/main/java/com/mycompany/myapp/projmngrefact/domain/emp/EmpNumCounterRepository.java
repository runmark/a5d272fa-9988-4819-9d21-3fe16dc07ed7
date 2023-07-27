package com.mycompany.myapp.projmngrefact.domain.emp;

public interface EmpNumCounterRepository {
    void save(EmpNumCounter empNumCounter);

    EmpNumCounter findByYear(Long tenantId, int yearNum);

    Integer increaseMaxNumByYear(Long tenantId, int yearNum);

}
