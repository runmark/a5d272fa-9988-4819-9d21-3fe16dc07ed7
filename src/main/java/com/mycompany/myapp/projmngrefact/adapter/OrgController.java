package com.mycompany.myapp.projmngrefact.adapter;

import com.mycompany.myapp.projmngrefact.application.CreateOrgRequest;
import com.mycompany.myapp.projmngrefact.application.OrgResponse;
import com.mycompany.myapp.projmngrefact.application.OrgService;
import com.mycompany.myapp.projmngrefact.application.UpdateOrgBasicRequest;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrgController {

  private final OrgService orgService;

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
    // TODO:
    return new OrgResponse();
  }

  @PostMapping("/api/organizations/{id}/cancel")
  public Long cancelOrg(@PathVariable Long id, @RequestParam Long tenant) {
    // TODO:
    return 1L;
  }

  private Long acquireUserId() {
    // TODO: use JWT
    return 1L;
  }
}
