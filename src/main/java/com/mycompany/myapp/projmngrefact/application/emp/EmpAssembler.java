package com.mycompany.myapp.projmngrefact.application.emp;

import com.mycompany.myapp.projmngrefact.domain.CommonOrgValidator;
import com.mycompany.myapp.projmngrefact.domain.emp.Emp;
import com.mycompany.myapp.projmngrefact.domain.emp.EmpStatus;
import com.mycompany.myapp.projmngrefact.domain.emp.Gender;
import com.mycompany.myapp.projmngrefact.domain.emp.Period;
import com.mycompany.myapp.projmngrefact.domain.emp.SkillLevel;

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
                .setGender(Gender.ofCode(request.getGenderCode()));

        request.getSkills().stream().forEach(s -> result.addSkill(s.getSkillTypeId(),
                SkillLevel.ofCode(s.getLevelCode()), s.getDuration(), userId));

        request.getExperiences().forEach(e -> result.addExperience(
                Period.of(e.getStartDate(), e.getEndDate()), e.getCompany(), userId));

        request.getPostCodes().forEach((p -> result.addEmpPost(p, userId)));

        return result;
    }

    void validateCreateRequest(CreateEmpRequest request) {
        assertOrg.shouldValid(
                request.getTenantId(), request.getOrgId());
    }

    public EmpResponse toResponse(Emp emp) {
        return null;
    }

}
