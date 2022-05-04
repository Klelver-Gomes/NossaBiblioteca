package br.edu.catolica.ppi.nossaBiblioteca.controller;

import br.edu.catolica.ppi.nossaBiblioteca.model.Emprestimo;
import br.edu.catolica.ppi.nossaBiblioteca.service.EmprestimoService;
import com.google.gson.internal.LinkedTreeMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping("/save/professor")
    public ResponseEntity saveOrUpdateProfessor (@RequestBody HashMap<String , Object> emprestimo){
        Emprestimo em = emprestimoService.saveOrUpdateEmprestimoProfessor(emprestimo);
        if (em != null){
            return ResponseEntity.ok()
                    .body(em);
        }
        return ResponseEntity.badRequest().body("ERROR: Emprestimo invalido");
    }

    @PostMapping("/save/aluno")
    public ResponseEntity <Object> saveOrUpdateAluno (@RequestBody HashMap<String , Object> emprestimo){
        Emprestimo em = emprestimoService.saveOrUpdateEmprestimoAluno(emprestimo);
        if (em != null){
            return ResponseEntity.ok()
                    .body(em);
        }
        return ResponseEntity.badRequest().body("ERROR: Emprestimo invalido");
    }

    @GetMapping("/nomepessoa/{nome}")
    public ResponseEntity findByNamePessoa(@PathVariable("nome") String nome){
        return  ResponseEntity.ok().body(emprestimoService.findByNamePessoa(nome));
    }

    @GetMapping("/getid/{id}")
    public ResponseEntity findByID (@PathVariable("id") UUID id){
        return  ResponseEntity.ok().body(emprestimoService.findByID(id));
    }
}
