package com.backend.backendAp.controllers;


import com.backend.backendAp.DAO.skill.SkillsDao;
import com.backend.backendAp.models.skill.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/argp")
@CrossOrigin(origins = "https://portfolio-219c8.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class SkillsController {

    @Autowired
    SkillsDao skillsDao;


    @GetMapping("/skills")
    public List<Skills> getSkills(){
        return skillsDao.getSkills();
    }


    @PostMapping("/skills")
    public Skills addSkill(@RequestBody Skills skill){
        return skillsDao.addSkill(skill);
    }

    @GetMapping("/skills/{id}")
    public ResponseEntity<Skills> searchSkill(@PathVariable int id){
        Skills skill = skillsDao.findById(id);

        return ResponseEntity.ok(skill);
    }


    @PutMapping("/skills/{id}")
    public ResponseEntity<Skills> editSkill(@PathVariable int id, @RequestBody Skills skillToEdit){
        Skills skill = skillsDao.findById(id);

        skill.setProgreso(skillToEdit.getProgreso());

        Skills skillEdited = skillsDao.addSkill(skill);

        return ResponseEntity.ok(skillEdited);
    }


    @DeleteMapping("/skills/{id}")
    public void deleteSkill(@PathVariable int id){
       skillsDao.delete(id);
    }

}
