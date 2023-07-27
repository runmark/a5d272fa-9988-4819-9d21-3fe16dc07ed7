package com.mycompany.myapp.projmngrefact.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class CommonOrgValidator {

    private final OrgRepository orgRepository;

    @Autowired
    public CommonOrgValidator(OrgRepository orgRepository) {
        this.orgRepository = orgRepository;
    }

    public void shouldValid(Long tenantId, Long orgId) {
        if (!orgRepository.existsByIdAndStatus(tenantId, orgId, OrgStatus.EFFECTIVE)) {
            throw new BusinessException("id为'" + orgId + "'的组织不是有效组织！");
        }
    }

}
