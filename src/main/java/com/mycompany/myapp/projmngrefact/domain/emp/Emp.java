package com.mycompany.myapp.projmngrefact.domain.emp;

import com.mycompany.myapp.projmngrefact.domain.BusinessException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Emp extends AggregateRoot {

    protected Long id;
    final protected Long tenantId;
    protected Long orgId;

    protected String empNum;
    protected String idNum;

    protected String name;
    protected Gender gender;
    protected LocalDate dob;
    protected EmpStatus status;
    // protected List<Skill> skills;
    final protected Map<Long, Skill> skills = new HashMap<>();
    // protected List<WorkExperience> experiences;
    final protected Map<Period, WorkExperience> experiences = new HashMap<>();

    final protected List<EmpPost> empPosts = new ArrayList<>();

    // 用于新建员工
    public Emp(Long tenantId, EmpStatus status, Long createdBy) {
        super(LocalDateTime.now(), createdBy);
        this.tenantId = tenantId;
        this.status = status;
    }

    // 用于从数据库重建员工
    public Emp(Long tenantId, Long id, LocalDateTime createdAt, Long createdBy) {
        super(createdAt, createdBy);
        this.id = id;
        this.tenantId = tenantId;
    }

    public Long getId() {
        return id;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public Emp setOrgId(Long orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getEmpNum() {
        return empNum;
    }

    public Emp setEmpNum(String empNum) {
        this.empNum = empNum;
        return this;
    }

    public String getIdNum() {
        return idNum;
    }

    public Emp setIdNum(String idNum) {
        this.idNum = idNum;
        return this;
    }

    public String getName() {
        return name;
    }

    public Emp setName(String name) {
        this.name = name;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Emp setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Emp setDob(LocalDate dob) {
        this.dob = dob;
        return this;
    }

    public EmpStatus getStatus() {
        return status;
    }

    Emp becomeRegular() {
        status = status.becomeRegular();
        return this;
    }

    Emp terminate() {
        status = status.terminate();
        return this;
    }

    public Collection<Skill> getSkills() {
        // return Collections.unmodifiableList(skills);
        return Collections.unmodifiableCollection(skills.values());

    }

    public Optional<Skill> getSkill(Long skillTypeId) {
        return Optional.ofNullable(skills.get(skillTypeId));
    }

    public void addSkill(Long skillTypeId, SkillLevel level, Integer duration, Long userId) {
        skillTypeShouldNotDuplicated(skillTypeId);

        Skill newSkill = new Skill(tenantId, skillTypeId, userId).setLevel(level).setDuration(duration);

        skills.put(skillTypeId, newSkill);
    }

    public Emp updateSkill(Long skillTypeId, SkillLevel level, Integer duration, Long userId) {

        Skill theSkill = this.getSkill(skillTypeId)
                .orElseThrow(() -> new IllegalArgumentException("不存在要修改的skillTypeId!"));

        if (theSkill.getLevel() != level
                || !theSkill.getDuration().equals(duration)) {
            theSkill.setLevel(level)
                    .setDuration(duration)
                    .setLastUpdatedBy(userId)
                    .setLastUpdatedAt(LocalDateTime.now())
                    .toUpdate();
        }
        return this;
    }

    public Emp deleteSkill(Long skillTypeId) {
        this.getSkill(skillTypeId)
                .orElseThrow(() -> new IllegalArgumentException("Skills中不存在要删除的skillTypeId!"))
                .toDelete();
        return this;
    }

    private void skillTypeShouldNotDuplicated(Long newSkillTypeId) {
        if (skills.get(newSkillTypeId) != null) {
            throw new BusinessException("同一技能不能录入两次！");
        }
    }

    public Collection<WorkExperience> getExperiences() {
        return Collections.unmodifiableCollection(experiences.values());
    }

    public Optional<WorkExperience> getExperience(Period period) {
        return Optional.ofNullable(experiences.get(period));
    }

    public void addExperience(Period period, String company, Long userId) {
        durationShouldNotOverlap(period);

        WorkExperience newExperience = new WorkExperience(
                tenantId, period, LocalDateTime.now(), userId)
                .setCompany(company);
        experiences.put(period, newExperience);
    }

    public Emp updateExperience(Period period, String company, Long userId) {
        WorkExperience theExperience = this.getExperience(period)
                .orElseThrow(() -> new IllegalArgumentException("不存在要修改的 WorkExperience!"));
        if (!theExperience.getCompany().equals(company)) {
            theExperience.setCompany(company)
                    .setLastUpdatedBy(userId)
                    .setLastUpdatedAt(LocalDateTime.now())
                    .toUpdate();
        }

        return this;
    }

    public Emp deleteExperience(Period period) {
        this.getExperience(period)
                .orElseThrow(() -> new IllegalArgumentException("Experiences中不存在要删除的period!"))
                .toDelete();
        return this;
    }

    private void durationShouldNotOverlap(Period newPeriod) {
        // if (experiences.stream().anyMatch(e -> e.getPeriod().overlap(newPeriod))) {
        if (experiences.values().stream().anyMatch(e -> e.getPeriod().overlap(newPeriod))) {
            throw new BusinessException("工作经验的时间段不能重叠!");
        }
    }

    public List<EmpPost> getEmpPosts() {
        return Collections.unmodifiableList(empPosts);
    }

    public Emp addEmpPost(String postCode, Long userId) {
        EmpPost post = new EmpPost(LocalDateTime.now(), userId);
        post.setPostCode(postCode);
        empPosts.add(post);
        return this;
    }

    public Emp deleteEmpPost(String postCode, Long userId) {
        // TODO ...
        return this;
    }

}
