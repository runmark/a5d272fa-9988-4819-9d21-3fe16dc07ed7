package com.mycompany.myapp.projmngrefact.application.emp;

import java.time.LocalDateTime;
import java.util.Optional;

import com.mycompany.myapp.projmngrefact.domain.emp.Emp;
import com.mycompany.myapp.projmngrefact.domain.emp.Gender;
import com.mycompany.myapp.projmngrefact.domain.emp.Skill;
import com.mycompany.myapp.projmngrefact.domain.emp.SkillLevel;

public class EmpUpdator {

    public void update(Emp emp, UpdateEmpRequest request, Long userId) {
        emp.setIdNum(request.getIdNum())
                .setName(request.getName())
                .setDob(request.getDob())
                .setGender(Gender.ofCode(request.getGenderCode()))
                .setLastUpdatedAt(LocalDateTime.now())
                .setLastUpdatedBy(userId)
                .toUpdate();

        updateSkills(emp, request, userId);
        updateExperiences(emp, request, userId);
    }

    private void updateSkills(Emp emp, UpdateEmpRequest request, Long userId) {
        deleteAbsentSkills(emp, request);
        operatePresentSkills(emp, request, userId);
    }

    private void operatePresentSkills(Emp emp, UpdateEmpRequest request, Long userId) {
        for (SkillDto skill : request.getSkills()) {

            Optional<Skill> skillOpt = emp.getSkill(skill.getSkillTypeId());

            if (skillOpt.isPresent()) {
                emp.updateSkill(skill.getSkillTypeId(), SkillLevel.ofCode(skill.getLevelCode()), skill.getDuration(),
                        userId);
            } else {
                emp.addSkill(skill.getSkillTypeId(), SkillLevel.ofCode(skill.getLevelCode()), skill.getDuration(),
                        userId);
            }

        }

    }

    private void deleteAbsentSkills(Emp emp, UpdateEmpRequest request) {
        emp.getSkills().forEach(gottenSkill -> {
            if (request.isSkillAbsent(gottenSkill)) {
                emp.deleteSkill(gottenSkill.getSkillTypeId());
            }
        });
    }

}
