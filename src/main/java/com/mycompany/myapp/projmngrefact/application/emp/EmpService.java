package com.mycompany.myapp.projmngrefact.application.emp;

import com.mycompany.myapp.projmngrefact.domain.emp.Emp;
import com.mycompany.myapp.projmngrefact.domain.emp.EmpRepository;

public class EmpService {
    private final EmpRepository empRepository;
    private final EmpAssembler empAssembler;

    public EmpService(EmpRepository empRepository, EmpAssembler empAssembler) {
        this.empRepository = empRepository;
        this.empAssembler = empAssembler;
    }

    public EmpResponse addEmp(CreateEmpRequest request, Long userId) {
        Emp emp = empAssembler.toEmp(request, userId);
        empRepository.save(emp);

        return empAssembler.toResponse(emp);

    }
}
