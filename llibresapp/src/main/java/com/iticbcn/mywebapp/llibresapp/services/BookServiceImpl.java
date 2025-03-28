package com.iticbcn.mywebapp.llibresapp.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iticbcn.mywebapp.llibresapp.model.Llibre;
import com.iticbcn.mywebapp.llibresapp.repositories.RepoLlibre;

@Service
public class BookServiceImpl implements BookService {
    
    private final RepoLlibre repository;

    @Autowired
    public BookServiceImpl(RepoLlibre repoLlibre) {
        this.repository = repoLlibre;
    }

    @Override
    public Set<Llibre> findAll() {
        return repository.findAll();
    }


    @Override
    public Set<Llibre> findByTitolAndEditorial(String titol, String editorial) throws Exception {
        return repository.findByTitolAndEditorial(titol, editorial);
    }

    @Override
    public boolean validateISBNFormat(String isbn) {
        return isbn.matches("^(?=(?:\\D\\d){10}(?:(?:\\D\\d){3})?$)[\\d-]+$");

    }

    @Override
    public Llibre findByTitol(String titol) throws Exception {
        return repository.findByTitol(titol);
    }

    @Override
    public Optional<Llibre> findByIdLlibre(int idLlibre) {
        return repository.findById((long) idLlibre);
    }

    @Override
    public Llibre save(Llibre llibre){
        return repository.save(llibre);
    }
}
