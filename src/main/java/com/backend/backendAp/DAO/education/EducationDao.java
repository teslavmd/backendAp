package com.backend.backendAp.DAO.education;

import com.backend.backendAp.models.education.Education;

import java.util.List;

public interface EducationDao {
    List<Education> getAllEducation();

    Education addEducation(Education education);

    Education searchEducation(Integer id);

    Education deleteEducation(Integer id);
}
