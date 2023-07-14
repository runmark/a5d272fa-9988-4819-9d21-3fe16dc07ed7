package com.mycompany.myapp.projmng.infrastructure.primary;

import com.mycompany.myapp.projmng.application.CreateOrgRequest;
import com.mycompany.myapp.projmng.application.OrgResponse;
import com.mycompany.myapp.projmng.application.OrgService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class OrgController {

  private final OrgService orgService;

  public OrgController(OrgService orgService) {
    this.orgService = orgService;
  }

  @PostMapping("/api/organizations")
  public OrgResponse addOrg(@RequestParam("userid") Integer userId, @RequestBody CreateOrgRequest request) {
    return orgService.addOrg(request, userId);
  }
}
