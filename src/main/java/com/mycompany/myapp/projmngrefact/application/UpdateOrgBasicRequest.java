package com.mycompany.myapp.projmngrefact.application;

// tenant should not blank
// tenant should be valid
// superior ...
// org type should be valid
// leader should be valid
// name should not blank
// created user should not blank

public class UpdateOrgBasicRequest {

  private Long tenant;
  private Long leader;
  private String name;

  public Long getTenant() {
    return tenant;
  }

  public void setTenant(Long tenant) {
    this.tenant = tenant;
  }

  public Long getLeader() {
    return leader;
  }

  public void setLeader(Long leader) {
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
    return "OrgDto{" + " tenant=" + tenant + ", leader=" + leader + ", name='" + name + '\'' + '}';
  }
}
