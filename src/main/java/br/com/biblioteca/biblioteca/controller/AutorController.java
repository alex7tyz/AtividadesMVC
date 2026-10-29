package br.com.biblioteca.biblioteca.controller;

import br.com.biblioteca.biblioteca.model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/autores")
public class AutorController {

    // GET /autores -> link do menu, leva direto ao formulário
    @GetMapping
    public String inicio() {
        return "redirect:/autores/novo";
    }

    // GET /autores/novo -> abre o formulário
    @GetMapping("/novo")
    public String novoAutor(Model model) {
        model.addAttribute("autor", new Autor());
        return "autores/form";
    }

    // POST /autores -> recebe os dados do formulário
    @PostMapping
    public String cadastrarAutor(@ModelAttribute Autor autor, Model model) {
        model.addAttribute("autor", autor);
        return "autores/confirmacao";
    }

}