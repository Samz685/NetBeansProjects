/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package biblioteca_spring.biblioteca_spring.controllers;

import biblioteca_spring.biblioteca_spring.models.Libro;
import biblioteca_spring.biblioteca_spring.repositories.LibroRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import java.util.HashMap;
import java.util.ArrayList;

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
@RequestMapping("/biblioteca")
public class LibroController {
    
    @Autowired
    LibroRepository repo;
    
    @GetMapping()
    public List<Libro> list() {
        return repo.findAll();
    }
    
    @GetMapping("/libros")
    public ResponseEntity<List<HashMap<String, Object>>> getLibros() {
        List<Libro> libros = repo.findAll();
        if (!libros.isEmpty()) {
            List<HashMap<String, Object>> librosResumen = new ArrayList<>();
            for (Libro libro : libros) {
                HashMap<String, Object> libroResumen = new HashMap<>();
                libroResumen.put("id", libro.getId());
                libroResumen.put("titulo", libro.getTitulo());
                librosResumen.add(libroResumen);
            }
            return new ResponseEntity<List<HashMap<String, Object>>>(librosResumen, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    //se usa optional porque se encapsula dentro el obj libro por si no existe
    //con responseEntity se usa para en el caso de no haber libro, lance un error o mensaje que queramos
    @GetMapping("/{id}")
    public ResponseEntity<Libro> get(@PathVariable Long id) {
        if(repo.existsById(id)){
            return new ResponseEntity<Libro>(repo.findById(id).get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }
    
    @GetMapping("/titulo/{id}")
    public ResponseEntity<HashMap<String, Object>> getTitulo(@PathVariable Long id) {
        if(repo.existsById(id)){
            
            Libro libro = repo.findById(id).get();
            HashMap<String, Object> libroResumen = new HashMap<>();
            
            libroResumen.put("id", libro.getId());
            libroResumen.put("titulo", libro.getTitulo());
            return new ResponseEntity<HashMap<String, Object>>(libroResumen, HttpStatus.OK);
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
    public ResponseEntity<Libro> post(@RequestBody Libro input) {
        
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
