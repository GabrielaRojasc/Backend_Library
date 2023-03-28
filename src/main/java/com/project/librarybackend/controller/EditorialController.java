package com.project.librarybackend.controller;

import com.project.librarybackend.models.Editorial;
import com.project.librarybackend.services.EditorialServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("editorial")
public class EditorialController {

    @Autowired
    private EditorialServices editorialServices;

    //get all
    @GetMapping("all")
    public List<Editorial> getAllEditorial(){
        return editorialServices.getAllEditorial();
    }

    //get por id, path variable con ("{id_editorial}")
    @GetMapping("{id_editorial")
    public Optional<Editorial> getEditorial(@PathVariable ("{id_editorial}") int id_editorial){
        return editorialServices.getEditorial(id_editorial);
    }

    //insert, post + @RequestBody
    @PostMapping("insert")
    public Editorial insertEditorial(@RequestBody Editorial editorial){
        return editorialServices.insertEditorial(editorial);
    }

    //update, put + @RequestBody
    @PutMapping("update")
    public Editorial updateEditorial (@RequestBody Editorial editorial){
        return editorialServices.updateEditorial(editorial);
    }

    //delete + @PathVariable
    @DeleteMapping("delete/{id_editorial}")
    public Boolean deleteEditorial (@PathVariable int id_editorial){
        return editorialServices.deleteEditorial(id_editorial);
    }

}
