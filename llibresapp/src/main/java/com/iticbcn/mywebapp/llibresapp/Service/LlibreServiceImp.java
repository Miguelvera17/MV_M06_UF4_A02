package com.iticbcn.mywebapp.llibresapp.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import com.iticbcn.mywebapp.llibresapp.Model.Llibre;
import com.iticbcn.mywebapp.llibresapp.Repository.Repositori;


public class LlibreServiceImp implements LlibreService{
    
    @Autowired
    private Repositori repositori;
    
    @Override
    public Set<Llibre> findAll() {
        return repositori.findAll();
    }

    @Override
    public Llibre findByTitol(String title) {

    }

    @Override
    public List<Llibre> findBytitolAndEditorial(String title, String editorial) {

        return null;
    }
}
