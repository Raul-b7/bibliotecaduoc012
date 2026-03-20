package com.example.bibliotecaduoc.repository;

import com.example.bibliotecaduoc.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {

    //Arreglo que guarda todos los libros//
    private List<Libro> listaLibros = new ArrayList<>();

    // Metodo que retorna todos los libros//
    public List<Libro> obtenerLibros() {
        return listaLibros;
    } 

    //Buscar un libro por su id//
    public Libro buscarporid(int id) {
        for(Libro libro : listaLibros) {
            if (libro.getId() == id) {
                return libro;
                
            }
        }
        return null;
    }

    // buscar un libro por su isnb//

    public Libro buscarporisnb(String isnb) {
        for (Libro libro : listaLibros){
            if (libro.getIsbn().equals(isnb)) {
                return libro;
                
            }
        }
        return null;
    }

    //guardar libro//
    public Libro guardar (Libro lib){
        listaLibros.add(lib);
        return lib ;

    }

    public Libro actualizar(Libro lib) {
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i< listaLibros.size(); i++){
            if (listaLibros.get(i).getId() == lib.getId()) {
                id = lib.getId();
                idPosicion = i;
            }
          

        }

        Libro libro1 = new Libro();
        
    }

}
