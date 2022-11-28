package com.backend.backendAp.DAO.aboutme;


import com.backend.backendAp.models.aboutme.AboutMe;

public interface AboutMeDao {
    AboutMe getAboutMe();

    AboutMe addAboutMe(AboutMe aboutme);
}
