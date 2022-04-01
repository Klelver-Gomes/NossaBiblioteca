package br.edu.catolica.ppi.nossaBiblioteca.controller;

import br.edu.catolica.ppi.nossaBiblioteca.model.Livro;
import br.edu.catolica.ppi.nossaBiblioteca.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Livro livro){
        return ResponseEntity.ok()
                .body(livroService.saveOrUpdate(livro));
    }

    @GetMapping("/getAllLivro")
    public ResponseEntity getAllLivro(){
        return ResponseEntity.ok().body(livroService.getAllLivro());
    }



}
