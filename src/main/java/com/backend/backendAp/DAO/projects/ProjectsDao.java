package com.backend.backendAp.DAO.projects;

import com.backend.backendAp.models.projects.Projects;

import java.util.List;

public interface ProjectsDao {

    List<Projects> getProjects();

    Projects addProject(Projects project);

    Projects findById(int id);

    void delete(int id);
}
