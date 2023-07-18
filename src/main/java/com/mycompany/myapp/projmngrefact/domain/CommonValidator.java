package com.mycompany.myapp.projmngrefact.domain;

import com.mycompany.myapp.projmngrefact.adapter.TenantRepository;
import com.mycompany.myapp.projmngrefact.adapter.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class CommonValidator {

  private final TenantRepository tenantRepository;
  private final UserRepository UserRepository;

  public CommonValidator(TenantRepository tenantRepository, UserRepository UserRepository) {
    this.tenantRepository = tenantRepository;
    this.UserRepository = UserRepository;
  }

  public void tenantShouldValid(Long tenantId) {
    if (!tenantRepository.existsByIdAndStatus(tenantId, TenantStatus.EFFECTIVE)) {
      throw new BusinessException("租户不存在！");
    }
  }
}
