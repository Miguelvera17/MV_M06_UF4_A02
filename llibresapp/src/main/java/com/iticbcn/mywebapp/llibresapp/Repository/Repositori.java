package com.iticbcn.mywebapp.llibresapp.Repository;

import java.util.Set;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iticbcn.mywebapp.llibresapp.Model.Llibre;

import io.micrometer.common.lang.NonNull;

@Repository
public interface Repositori extends CrudRepository<Llibre,Integer>{

    @Override
    @NonNull
    Set<Llibre> findAll();

    Llibre findByTitol(String title);

    Set<Llibre> findBytitolAndEditorial(String title, String editorial);
    
}


