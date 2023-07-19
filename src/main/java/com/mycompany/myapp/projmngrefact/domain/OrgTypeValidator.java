package com.mycompany.myapp.projmngrefact.domain;

import static com.mycompany.myapp.projmngrefact.common.StringUtil.isBlank;

public class OrgTypeValidator {

  private OrgTypeRepository orgTypeRepository;

  public void orgTypeShouldNotEmpty(String orgType) {
    if (isBlank(orgType)) {
      throw new BusinessException("组织类型不能为空");
    }
  }

  public void orgTypeShouldBeValid(Long tenant, String orgType) {
    if (!orgTypeRepository.existsByCodeAndStatus(tenant, orgType, OrgTypeStatus.EFFECTIVE)) {
      throw new BusinessException("组织类型不存在");
    }
  }

  public void shouldNotCreateEntpAlone(String orgType) {
    if ("ENTP".equals(orgType)) {
      throw new BusinessException("企业不能单独创建");
    }
  }
}
