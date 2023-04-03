package com.backend.backendAp.controllers;

import com.backend.backendAp.DAO.projects.ProjectsDao;
import com.backend.backendAp.models.projects.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/argp")
@CrossOrigin(origins = "https://portfolio-219c8.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class ProjectsController {

    @Autowired
    ProjectsDao projectsDao;

    @GetMapping("/projects")
    public List<Projects> getProjects(){

        return projectsDao.getProjects();

    }

    @PostMapping("/projects")
    public Projects addProject(@RequestBody Projects project){
        return projectsDao.addProject(project);
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Projects> searchProject(@PathVariable int id){
        Projects project = projectsDao.findById(id);

        return ResponseEntity.ok(project);
    }

    @DeleteMapping("/projects/{id}")
    public void deleteProject(@PathVariable int id){
        projectsDao.delete(id);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<Projects> editProject(@PathVariable int id, @RequestBody Projects projectToEdit){
        Projects project = projectsDao.findById(id);

        project.setNombre(projectToEdit.getNombre());
        project.setFoto(projectToEdit.getFoto());
        project.setTecnologias(projectToEdit.getTecnologias());
        project.setDescripcion(projectToEdit.getDescripcion());
        project.setUrl_git(projectToEdit.getUrl_git());
        project.setUrl_web(projectToEdit.getUrl_web());

        Projects projectEdited = projectsDao.addProject(project);

        return ResponseEntity.ok(projectEdited);

    }



}
