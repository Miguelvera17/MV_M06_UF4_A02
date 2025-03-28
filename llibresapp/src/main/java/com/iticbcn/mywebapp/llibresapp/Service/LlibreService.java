package com.iticbcn.mywebapp.llibresapp.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import com.iticbcn.mywebapp.llibresapp.Model.Llibre;
import org.springframework.stereotype.Service;

@Service
public interface LlibreService {
    
    Set<Llibre> findAll();
    Llibre findByTitol(String title);
    List<Llibre> findBytitolAndEditorial(String title, String editorial);
    Optional<Llibre> findByIdLlibre(int idLlibre);
    Boolean validaISBN(String isbn);

}