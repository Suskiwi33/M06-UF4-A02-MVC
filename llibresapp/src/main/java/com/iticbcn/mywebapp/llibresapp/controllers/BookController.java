package com.iticbcn.mywebapp.llibresapp.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.iticbcn.mywebapp.llibresapp.model.Llibre;
import com.iticbcn.mywebapp.llibresapp.repositories.RepoLlibre;
import com.iticbcn.mywebapp.llibresapp.services.BookService;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String iniciar(Model model) {
        return "login";
    }


    @PostMapping("/index")
    public String login(@RequestParam("user") String user, @RequestParam("password") String password, Model model) {

        if (password.equals("toni") && user.equals("h3ll0!!")) {
            return "index";
        } else {
            return "login";
        }
    }


    @GetMapping("/consulta") 
    public String consulta(Model model) {

        ArrayList<Llibre> llibres = (ArrayList<Llibre>) bookService.findAll();

        model.addAttribute("llibres", llibres);
        
        return "consulta";
    }

    @PostMapping("/inserir")
    public String inserir(@RequestParam(name = "titol") String titol,
                          @RequestParam(name = "autor") String autor,
                          @RequestParam(name = "editorial") String editorial,
                          @RequestParam(name = "datapublicacio") String datapublicacio,
                          @RequestParam(name = "tematica") String tematica,
                          @RequestParam(name = "isbn") String isbn,
                          Model model) {

        String message = "";
        boolean llibreErr = false;
        LocalDate dataPublicacio;

        try {
            dataPublicacio = LocalDate.parse(datapublicacio);
        } catch (Exception e) {
            message = "El format de la data de publicació és incorrecte.";
            llibreErr = true;
            model.addAttribute("message", message);
            model.addAttribute("llibreErr", llibreErr);
            return "inserir";
        }

        try {
            bookService.validateISBNFormat(isbn);
        } catch (Exception e) {
            message = "El format del isbn és incorrecte.";
            llibreErr = true;
            model.addAttribute("message", message);
            model.addAttribute("llibreErr", llibreErr);
            return "inserir";
        }

        Llibre llibre = new Llibre(0, titol, autor, editorial, dataPublicacio, tematica, isbn);
        bookService.save(llibre);
        return "inserir";
    }
    
        @GetMapping("/cercaid")
    public String inputCerca(Model model) {
        Llibre llibre = new Llibre();
        llibre.setId_Llibre(0);
        model.addAttribute("llibreErr", true);
        model.addAttribute("message", "");
        model.addAttribute("llibre", llibre);

        return "cercaid";

    }


        @PostMapping("/cercaid")
        public String cercaId(
                              @RequestParam(name = "idLlibre", required = false) String idLlibre, 
                              Model model) {
            
            int idLlib = 0;
            String message = "";
            boolean llibreErr = false;
    
            try {
                idLlib = Integer.parseInt(idLlibre);
                Optional<Llibre> llibre = bookService.findByIdLlibre(idLlib);
                if(llibre !=null) {
                    model.addAttribute("llibre", llibre);
                } else {
                    message = "No hi ha cap llibre amb aquesta id";
                    llibreErr = true;
                }
    
            } catch (Exception e) {
                message = "La id de llibre ha de ser un nombre enter";
                llibreErr = true;
            } 
            
            model.addAttribute("message", message);
            model.addAttribute("llibreErr",llibreErr);
    
            return "cercaid";
    
        }
        
            @PostMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
    }

}