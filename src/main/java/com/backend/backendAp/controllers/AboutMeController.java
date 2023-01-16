package com.backend.backendAp.controllers;


import com.backend.backendAp.DAO.aboutme.AboutMeDao;
import com.backend.backendAp.models.aboutme.AboutMe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/argp")
@CrossOrigin(origins = "https://portfolio-219c8.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class AboutMeController {

    @Autowired
    AboutMeDao aboutMeDao;

    @GetMapping("/aboutme")
    public AboutMe getAboutMe(){
        return aboutMeDao.getAboutMe();
    }


    @PutMapping("/aboutme")
    public ResponseEntity<AboutMe> editAboutMe(@RequestBody AboutMe aboutMeToEdit){
        AboutMe aboutMe = aboutMeDao.getAboutMe();

        aboutMe.setNombre(aboutMeToEdit.getNombre());
        aboutMe.setApellido(aboutMeToEdit.getApellido());
        aboutMe.setEdad(aboutMeToEdit.getEdad());
        aboutMe.setFecha(aboutMeToEdit.getFecha());
        aboutMe.setTexto(aboutMeToEdit.getTexto());

        AboutMe aboutMeEdited = aboutMeDao.addAboutMe(aboutMe);

        return ResponseEntity.ok(aboutMeEdited);

    }

}
