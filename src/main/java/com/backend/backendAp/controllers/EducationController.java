package com.backend.backendAp.controllers;


import com.backend.backendAp.DAO.education.EducationDao;
import com.backend.backendAp.models.education.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/argp")
//@CrossOrigin("http://localhost:4200")
@CrossOrigin(origins = "https://portfolio-219c8.web.app")
public class EducationController {

    @Autowired
    private EducationDao educationDao;

    @GetMapping("/education")
    public List<Education> getEducation(){
        return  this.educationDao.getAllEducation();
    }

    @PostMapping("/education")
    public Education addEducation(@RequestBody Education education){
        return this.educationDao.addEducation(education);
    }

    @GetMapping("/education/{id}")
    public ResponseEntity<Education> searchEducation(@PathVariable Integer id){
        Education education = this.educationDao.searchEducation(id);
        return ResponseEntity.ok(education);
    }

    @PutMapping("/education/{id}")
    public ResponseEntity<Education> editEducation(@PathVariable Integer id, @RequestBody Education educationToEdit){
        Education education = this.educationDao.searchEducation(id);

        education.setNombre(educationToEdit.getNombre());
        education.setOrientacion(educationToEdit.getOrientacion());
        education.setFechaInicio(educationToEdit.getFechaInicio());
        education.setFechaFinal(educationToEdit.getFechaFinal());

        Education educationEdited = this.educationDao.addEducation(education);
        return ResponseEntity.ok(educationEdited);
    }

    @DeleteMapping("/education/{id}")
    public ResponseEntity<Education> deleteEducation(@PathVariable Integer id){

        Education education = this.educationDao.deleteEducation(id);

        return ResponseEntity.ok(education);
    }


}
