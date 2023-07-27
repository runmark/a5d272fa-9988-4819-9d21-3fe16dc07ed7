package com.mycompany.myapp.projmngrefact.application.emp;

import com.mycompany.myapp.projmngrefact.domain.BusinessException;
import com.mycompany.myapp.projmngrefact.domain.emp.Emp;
import com.mycompany.myapp.projmngrefact.domain.emp.EmpRepository;

import jakarta.transaction.Transactional;

public class EmpService {
    private final EmpRepository empRepository;
    private final EmpAssembler empAssembler;
    private final EmpUpdator updator;

    public EmpService(EmpRepository empRepository, EmpAssembler empAssembler, EmpUpdator updator) {
        this.empRepository = empRepository;
        this.empAssembler = empAssembler;
        this.updator = updator;
    }

    @Transactional
    public EmpResponse addEmp(CreateEmpRequest request, Long userId) {
        Emp emp = empAssembler.toEmp(request, userId);
        empRepository.save(emp);

        return empAssembler.toResponse(emp);
    }

    @Transactional
    public EmpResponse updateEmp(Long empId, UpdateEmpRequest request, Long userId) {

        Emp emp = empRepository.findById(request.getTenantId(), empId)
                .orElseThrow(() -> new RuntimeException("emp not found"));

        updator.update(emp, request, userId);

        if (!empRepository.save(emp)) {
            throw new BusinessException("emp save failed");
        }

        return empAssembler.toResponse(emp);

    }
}
