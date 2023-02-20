/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package Spring_0.demo.controllers;

import Spring_0.demo.pokemon.Pokemon;
import Spring_0.demo.repositories.PokemonRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author Syzer
 */
@RestController
@RequestMapping("/pokemon2")
public class PokemonController {
    
    @Autowired
    PokemonRepository repo;
    
    @GetMapping()
    public List<Pokemon> list() {
        return repo.findAll();
    }
    
    //se usa optional porque se encapsula dentro el obj pokemon por si no existe
    //con responseEntity se usa para en el caso de no haber pokemon, lance un error o mensaje que queramos
    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> get(@PathVariable Long id) {
        if(repo.existsById(id)){
            return new ResponseEntity<Pokemon>(repo.findById(id).get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }
    
//    
//    @PutMapping("/{id}")
//    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
//        return null;
//    }
//    
    
    //el cuerpo de la peticion http es lo que pongamos nosotros en postman por ejemplo
    @PostMapping
    public ResponseEntity<Pokemon> post(@RequestBody Pokemon input) {
        
        repo.save(input);
        System.out.println(input);
        
        return new ResponseEntity<>(input, HttpStatus.CREATED);
    }
    
//    
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete(@PathVariable String id) {
//        return null;
//    }
    
}
