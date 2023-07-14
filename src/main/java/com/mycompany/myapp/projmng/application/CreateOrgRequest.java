package com.mycompany.myapp.projmng.application;

public class CreateOrgRequest {

  private String name;
  private Integer tenant;
  private String orgType;
  private Integer superior;
  private Integer leader;

  public Integer getTenantId() {
    return tenant;
  }

  public void setTenant(Integer tenant) {
    this.tenant = tenant;
  }

  public Integer getSuperiorId() {
    return superior;
  }

  public void setSuperior(Integer superior) {
    this.superior = superior;
  }

  public String getOrgTypeCode() {
    return orgType;
  }

  public void setOrgType(String orgType) {
    this.orgType = orgType;
  }

  public Integer getLeaderId() {
    return leader;
  }

  public void setLeader(Integer leader) {
    this.leader = leader;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return (
      "OrgDto{ tenant=" +
      tenant +
      ", superior=" +
      superior +
      ", orgType='" +
      orgType +
      '\'' +
      ", leader=" +
      leader +
      ", name='" +
      name +
      '\'' +
      '}'
    );
  }
}
