package com.mycompany.myapp.projmngrefact.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrgController {

  private final OrgService orgService;

  @Autowired
  public OrgController(OrgService orgService) {
    this.orgService = orgService;
  }

  @PostMapping("/api/organizations")
  public OrgResponse addOrg(@RequestBody CreateOrgRequest request) {
    Long userId = acquireUserId();
    return orgService.addOrg(request, userId);
  }

  @PatchMapping("/api/organizations/{id}")
  public OrgResponse updateOrgBasic(@PathVariable Long id, @RequestBody UpdateOrgBasicRequest request) {
    Long user = acquireUserId();
    return orgService.updateOrgBasic(id, request, user);
  }

  @PostMapping("/api/organizations/{id}/cancel")
  public Long cancelOrg(@PathVariable Long id, @RequestParam Long tenant) {
    Long user = acquireUserId();
    return orgService.cancelOrg(id, tenant, user);
  }

  private Long acquireUserId() {
    // TODO: use JWT
    return 1L;
  }
}
