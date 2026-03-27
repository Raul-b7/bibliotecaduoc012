package com.example.bibliotecaduoc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.repository.LibroRepository;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;


    public List <Libro> getLibros(){
        return libroRepository.obtenerLibros();

    }

    public Libro saveLibro(Libro libro) {
        return libroRepository.guardar(libro);

    }

    public Libro getLibroid(int id) {
        return libroRepository.buscarporid(id);
    }

    public Libro updateLibro (Libro libro) {
        return libroRepository.actualizar(libro);
    }

    public String deleteLibro(int id) {
        libroRepository.eliminar(id);
        return "producto eliminado";
    }

    public int totalLibrosV1(){
        return libroRepository.obtenerLibros().size();
    }

    public int totalLibrosV2(){
        return libroRepository.totalLibros();
    }

    //Buscar por ISBN

    public Libro buscarPorIsbn(String isbn){ // Libro viene de la clase libro que esta en model //
        List<Libro> libros = libroRepository.obtenerLibros();

            for (Libro l : libros) {
                if (l.getIsbn().equals(isbn)) {
                    return l;
                }
            }
            return null;
    }    

     //antidad por año

    public int buscarPorFechaPublicacion(int fechaPublicacio){
        List<Libro> libros = libroRepository.obtenerLibros();
        int contador = 0;

        for (Libro l : libros) {
            if (l.getFechaPublicacion() == fechaPublicacio){
                contador++;
            }
        }
         return contador;
    }

    // Buscar por autor

    public List<Libro> buscarPorAutor(String autor){
        List<Libro> libros = libroRepository.obtenerLibros();
        List<Libro> resultado = new java.util.ArrayList<>();

        for (Libro l : libros) {
            if (l.getAutor().equalsIgnoreCase(autor)) {
                resultado.add(l);
            }
        }

        return resultado;
}

     
}


