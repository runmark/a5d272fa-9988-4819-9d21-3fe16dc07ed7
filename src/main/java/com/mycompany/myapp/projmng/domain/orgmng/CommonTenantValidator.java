package com.mycompany.myapp.projmng.domain.orgmng;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.myapp.projmngrefact.domain.BusinessException;
import com.mycompany.myapp.projmngrefact.domain.TenantStatus;

public class CommonTenantValidator {

    private final TenantRepositoryJdbc tenantRepository;

    @Autowired
    public CommonTenantValidator(TenantRepositoryJdbc tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    public void shouldEffective(Long tenant) {
        // 租户必须有效
        if (!tenantRepository.existsByIdAndStatus(tenant, TenantStatus.EFFECTIVE)) {
            throw new BusinessException("id为'" + tenant + "'的租户不是有效租户！");
        }
    }

}
