package com.iticbcn.mywebapp.llibresapp.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.iticbcn.mywebapp.llibresapp.model.Llibre;

@Service
public interface BookService {

    Set<Llibre> findAll();

    Llibre findByTitol(String titol) throws Exception;

    Set<Llibre> findByTitolAndEditorial(String titol, String editorial) throws Exception;

    boolean validateISBNFormat(String isbn);

    Optional <Llibre> findByIdLlibre(int idLlibre);

    Llibre save(Llibre llibre);
}
