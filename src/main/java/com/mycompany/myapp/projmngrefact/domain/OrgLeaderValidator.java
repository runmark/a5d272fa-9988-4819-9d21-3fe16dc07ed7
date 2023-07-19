package com.mycompany.myapp.projmngrefact.domain;

public class OrgLeaderValidator {

  private EmpRepository empRepository;

  OrgLeaderValidator(EmpRepository empRepository) {
    this.empRepository = empRepository;
  }

  public void orgLeaderShouldValid(Long tenantId, Long leaderId) {
    if (leaderId != null && !empRepository.existsByIdAndStatus(tenantId, leaderId, EmpStatus.REGULAR, EmpStatus.PROBATION)) {
      throw new BusinessException("组织负责人不存在");
    }
  }
}
