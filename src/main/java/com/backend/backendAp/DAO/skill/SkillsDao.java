package com.backend.backendAp.DAO.skill;


import com.backend.backendAp.models.skill.Skills;

import java.util.List;

public interface SkillsDao {

    List<Skills> getSkills();


    Skills addSkill(Skills skill);

    Skills findById(int id);


    void delete(int id);
}
