package br.edu.catolica.ppi.nossaBiblioteca.controller;

import br.edu.catolica.ppi.nossaBiblioteca.model.Aluno;
import br.edu.catolica.ppi.nossaBiblioteca.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @GetMapping("/id/{id}")
    public ResponseEntity getById(@PathVariable("id") UUID id){
        return ResponseEntity.ok().body(alunoService.findByID(id));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity getByCpf(@PathVariable("cpf") String cpf){
        return ResponseEntity.ok().body(alunoService.findByCpf(cpf));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity getByNome(@PathVariable("nome") String nome){
        return  ResponseEntity.ok().body(alunoService.FindByNome(nome));
    }

    @GetMapping("/findAll")
    public ResponseEntity findAll(){
        return ResponseEntity.ok().body(alunoService.getAll());
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody Aluno aluno){
        alunoService.remove(aluno);
        return ResponseEntity.noContent().build();
    }



}
