package com.mycompany.myapp.projmngrefact.application.emp;

import com.mycompany.myapp.projmngrefact.domain.emp.Emp;
import com.mycompany.myapp.projmngrefact.domain.emp.EmpStatus;

public class EmpAssembler {

    private final EmpNumGenerator empNumGenerator;
    private final CommonOrgValidator assertOrg;

    public EmpAssembler(EmpNumGenerator empNumGenerator, CommonOrgValidator assertOrg) {
        this.empNumGenerator = empNumGenerator;
        this.assertOrg = assertOrg;
    }

    Emp toEmp(CreateEmpRequest request, Long userId) {
        validateCreateRequest(request);

        String empNum = empNumGenerator.generateEmpNum(request.getTenantId());

        Emp result = new Emp(request.getTenantId(), EmpStatus.ofCode(request.getStatusCode()), userId)
                .setEmpNum(empNum)
                .setIdNum(request.getIdNum())
                .setOrgId(request.getOrgId())
                .setName(request.getName())
                .setDob(request.getDob())
                .setGender(Gender.ofCode(request.getGenderCode()))
    }

}
