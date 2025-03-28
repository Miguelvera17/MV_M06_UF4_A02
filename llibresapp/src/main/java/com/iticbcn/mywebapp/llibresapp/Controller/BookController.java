package com.iticbcn.mywebapp.llibresapp.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.iticbcn.mywebapp.llibresapp.Model.Llibre;
import com.iticbcn.mywebapp.llibresapp.Model.Usuaris;
import com.iticbcn.mywebapp.llibresapp.Repository.RepoLlibre;

import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("users")
public class BookController {

    @Autowired
    private RepoLlibre repoll;

    @GetMapping("/")
    public String iniciar() {
        return "login";
    }

    @PostMapping("/index")
    public String login(@ModelAttribute("users") Usuaris users, Model model) {
        if ("miguel".equals(users.getUsuari()) && "123456".equals(users.getPassword())) {
            return "index";
        }
        model.addAttribute("message", "Usuari o contrasenya incorrecta.");
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/consulta")
    public String consulta(Model model) {
        List<Llibre> llibres = repoll.findByID();
        model.addAttribute("llibres", llibres);
        return "consulta";
    }

    @GetMapping("/inserir")
    public String inputInserir(Model model) {
        model.addAttribute("llibre", new Llibre());
        return "inserir";
    }

    @GetMapping("/cercaid")
    public String inputCerca(Model model) {
        model.addAttribute("llibre", new Llibre());
        model.addAttribute("llibreErr", false);
        model.addAttribute("message", "");
        return "cercaid";
    }

    @PostMapping("/cercaid")
    public String cercaId(@RequestParam("idLlibre") Optional<Integer> idLlibre, Model model) {
        if (idLlibre.isPresent()) {
            Llibre llibre = repoll.findByID(idLlibre.get());
            if (llibre != null) {
                model.addAttribute("llibre", llibre);
            } else {
                model.addAttribute("message", "No hi ha cap llibre amb aquesta ID.");
                model.addAttribute("llibreErr", true);
            }
        } else {
            model.addAttribute("message", "La ID ha de ser un nombre enter.");
            model.addAttribute("llibreErr", true);
        }
        return "cercaid";
    }

    @PostMapping("/inserir")
    public String inserir(@RequestParam("idLlibre") String idLlibre,
                        @RequestParam("title") String title,
                        @RequestParam("author") String author,
                        @RequestParam("editorial") String editorial,
                        @RequestParam("publishedYear") String publishedYear,
                        @RequestParam("genre") String genre,
                        @RequestParam("isbn") String isbn,
                        Model model) {
        try {
            int idL = Integer.parseInt(idLlibre);
            LocalDate dateP = LocalDate.parse(publishedYear);
            Llibre llibre = new Llibre(title, author, editorial, dateP, genre, isbn);

            if (!llibreService.isValidIsbn(isbn)) {
                model.addAttribute("message", "Format d’ISBN incorrecte.");
                model.addAttribute("llibreErr", true);
                return "inserir"; 
            }

            llibreService.save(llibre);
            model.addAttribute("message", "Llibre inserit correctament!");
            return "consulta"; 

        } catch (Exception e) {
            model.addAttribute("message", "Error en les dades del llibre.");
            model.addAttribute("llibreErr", true);
            return "inserir";
        }
    }

    @PostMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
    }

    @ModelAttribute("users")
    public Usuaris getDefaultUser() {
        return new Usuaris();
    }
}
