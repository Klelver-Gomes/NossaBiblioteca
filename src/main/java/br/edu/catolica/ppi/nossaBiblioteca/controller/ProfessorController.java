package br.edu.catolica.ppi.nossaBiblioteca.controller;

import br.edu.catolica.ppi.nossaBiblioteca.model.Professor;
import br.edu.catolica.ppi.nossaBiblioteca.service.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("professor")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }


    @PostMapping("/save")
    public ResponseEntity saveOrUpdate (@RequestBody Professor professor){
        return ResponseEntity.ok()
                .body(professorService.saveOrUpdate(professor));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity findById(@PathVariable("id") UUID id){
        return ResponseEntity.ok().body(professorService.findById(id));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity findByCpf(@PathVariable("cpf") String cpf){
        return ResponseEntity.ok().body(professorService.findByCpf(cpf));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity findByNome(@PathVariable("nome") String nome){
        return  ResponseEntity.ok().body(professorService.findByNome(nome));
    }

    @GetMapping("/findAll")
    public ResponseEntity getAll(){
        return ResponseEntity.ok().body(professorService.getAll());
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody Professor professor){
        professorService.remove(professor);
        return ResponseEntity.noContent().build();
    }

}
