package br.edu.catolica.ppi.nossaBiblioteca.controller;

import br.edu.catolica.ppi.nossaBiblioteca.model.Bibliotecario;
import br.edu.catolica.ppi.nossaBiblioteca.service.BibliotecarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/bibliotecario")

public class BibliotecarioController {

    private final BibliotecarioService bibliotecarioService;

    public BibliotecarioController(BibliotecarioService bibliotecarioService) {
        this.bibliotecarioService = bibliotecarioService;
    }

    @PostMapping("/save")
    public ResponseEntity save (@RequestBody Bibliotecario bibliotecario){
        return ResponseEntity.ok()
                .body(bibliotecarioService.saveOrUpdate(bibliotecario));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getById(@PathVariable("id") UUID id){
        return ResponseEntity.ok().body(bibliotecarioService.findByID(id));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity getByCpf(@PathVariable("cpf") String cpf){
        return ResponseEntity.ok().body(bibliotecarioService.findByCpf(cpf));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity getByNome(@PathVariable("nome") String nome){
        return  ResponseEntity.ok().body(bibliotecarioService.FindByNome(nome));
    }

    @GetMapping("/findAll")
    public ResponseEntity findAll(){
        return ResponseEntity.ok().body(bibliotecarioService.getAll());
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody Bibliotecario bibliotecario){
        bibliotecarioService.remove(bibliotecario);
        return ResponseEntity.noContent().build();
    }

}
