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

    @GetMapping("/isbn{isbn}")
    public  ResponseEntity findByIsbn(@PathVariable Integer isbn){
        return ResponseEntity.ok().body(livroService.findByIsbn(isbn));
    }

    @GetMapping("/nome{nome}")
    public  ResponseEntity findByName(@PathVariable String nome){
        return ResponseEntity.ok().body(livroService.findByName(nome));
    }

    @DeleteMapping
    public ResponseEntity delete (@RequestBody Livro livro){
        livroService.remove(livro);
        return ResponseEntity.noContent().build();
    }



}
