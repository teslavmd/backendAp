package com.backend.backendAp.DAO.education;

import com.backend.backendAp.models.education.Education;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EducationDaoImp implements EducationDao{

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Education> getAllEducation() {
        String query = "FROM Education";

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Education addEducation(Education education) {
        return entityManager.merge(education);
    }

    @Override
    public Education searchEducation(Integer id) {
        String query = "FROM Education WHERE id = :id";

         List<Education> educationList = this.entityManager.createQuery(query)
                .setParameter("id", id)
                .getResultList();

         return educationList.get(0);
    }

    @Override
    public Education deleteEducation(Integer id) {
        Education education = entityManager.find(Education.class, id);
        entityManager.remove(education);
        return education;
    }
}
