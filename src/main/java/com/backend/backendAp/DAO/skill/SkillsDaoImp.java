package com.backend.backendAp.DAO.skill;

import com.backend.backendAp.models.skill.Skills;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class SkillsDaoImp implements SkillsDao{


    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    @Override
    public List<Skills> getSkills() {
        String query = "FROM Skills";

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Skills addSkill(Skills skill) {
        return entityManager.merge(skill);
    }

    @Override
    public Skills findById(int id) {
        String query = "FROM Skills WHERE id = :id";

        List<Skills> listSkills = entityManager.createQuery(query)
                .setParameter("id", id)
                .getResultList();

        return listSkills.get(0);

    }


    @Override
    public void delete(int id) {
        Skills skill = entityManager.find(Skills.class, id);

        entityManager.remove(skill);
    }
}
