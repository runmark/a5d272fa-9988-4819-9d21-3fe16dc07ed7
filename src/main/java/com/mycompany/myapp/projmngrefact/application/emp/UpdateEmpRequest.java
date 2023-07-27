package com.mycompany.myapp.projmngrefact.application.emp;

import com.mycompany.myapp.projmngrefact.domain.emp.Skill;

public class UpdateEmpRequest extends BaseEmpRequest {

    public boolean isSkillAbsent(Skill gottenSkill) {
        return skills.stream().noneMatch(s -> s.getSkillTypeId().equals(gottenSkill.getSkillTypeId()));
    }

}
