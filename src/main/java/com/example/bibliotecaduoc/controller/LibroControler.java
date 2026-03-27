package com.example.bibliotecaduoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.services.LibroService;

@Service

@RestController
@RequestMapping("/api/v1/libros")
public class LibroControler {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> listaLibros(){
        return libroService.getLibros();
    }


    @PostMapping
    public Libro agregaLibro(@RequestBody Libro libro){
        return libroService.saveLibro(libro);
    }

    @GetMapping("{id}")
    public Libro buscaLibro(@PathVariable int id){
        return libroService.getLibroid(id);
    }

    @PutMapping("{id}")
    public Libro actualizaLibro(@PathVariable int id, @RequestBody Libro Libro){
        // el id lo usaremos mas adelante
        return libroService.updateLibro(Libro);
    }

    @DeleteMapping("{id}")
    public String eliminarLibro (@PathVariable int id) {
        return libroService.deleteLibro(id);
    }

    @GetMapping("/total")
    public int totalLibrosV2(){
        return libroService.totalLibrosV2();
    }


}
