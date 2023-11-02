package com.backend.backendAp.DAO.aboutme;


import com.backend.backendAp.models.aboutme.AboutMe;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class AboutMeDaoImp implements AboutMeDao {


    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    @Override
    public AboutMe getAboutMe() {
        String query = "FROM AboutMe";

        List listArray = entityManager.createQuery(query)
                .getResultList();

        return (AboutMe) listArray.get(0);

    }

    @Override
    public AboutMe addAboutMe(AboutMe aboutme) {
        return entityManager.merge(aboutme);
    }
}
