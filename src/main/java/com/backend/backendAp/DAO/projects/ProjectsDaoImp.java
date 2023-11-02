package com.backend.backendAp.DAO.projects;

import com.backend.backendAp.models.projects.Projects;
import com.backend.backendAp.models.skill.Skills;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProjectsDaoImp implements ProjectsDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public List<Projects> getProjects() {
        String query = "FROM Projects";

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Projects addProject(Projects project) {
        return entityManager.merge(project);
    }

    @Override
    public Projects findById(int id) {
        String query = "FROM Projects WHERE id = :id";

        List<Projects> listProject = entityManager.createQuery(query)
                .setParameter("id", id)
                .getResultList();

        return listProject.get(0);
    }

    @Override
    public void delete(int id) {
        Projects project = entityManager.find(Projects.class, id);

        entityManager.remove(project);

    }
}
