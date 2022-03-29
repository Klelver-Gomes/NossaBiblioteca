package br.edu.catolica.ppi.nossaBiblioteca.controller;

import br.edu.catolica.ppi.nossaBiblioteca.model.Aluno;
import br.edu.catolica.ppi.nossaBiblioteca.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;


    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @PostMapping("/save")
    public ResponseEntity save (@RequestBody Aluno aluno){
        return ResponseEntity.ok()
                .body(alunoService.saveOrUpdate(aluno));
    }
}
