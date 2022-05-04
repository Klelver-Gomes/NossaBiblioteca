package br.edu.catolica.ppi.nossaBiblioteca.service;

import br.edu.catolica.ppi.nossaBiblioteca.model.*;
import br.edu.catolica.ppi.nossaBiblioteca.repository.AlunoRepository;
import br.edu.catolica.ppi.nossaBiblioteca.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;

    private final AlunoService alunoService;
    private final LivroService livroService;
    private final ProfessorService professorService;

    public EmprestimoService(EmprestimoRepository emprestimoRepository, AlunoService alunoService, LivroService livroService, ProfessorService professorService) {
        this.emprestimoRepository = emprestimoRepository;

        this.alunoService = alunoService;
        this.livroService = livroService;
        this.professorService = professorService;
    }


    public Emprestimo saveOrUpdateEmprestimoProfessor(HashMap<String, Object> emprestimo) {
        Professor professor = professorService.findById(UUID.fromString(emprestimo.get("idpessoa").toString()));
        List<Livro> livros = new ArrayList<>();
        for (String idLivro :
                (List<String>) emprestimo.get("livros")) {
            Livro livro = livroService.findByID(UUID.fromString(idLivro));
            if(livro.getQuantidade() > 0){
                livro.setQuantidade(livro.getQuantidade()-1);
                livros.add(livro);
                Emprestimo em = new Emprestimo();
                em.setPessoa(professor);
                em.setLivro(livros);
                em.setDataEmprestimo(LocalDate.now());
                return emprestimoRepository.save(em);
            }
        }
        return null;
    }

    public Emprestimo saveOrUpdateEmprestimoAluno(HashMap<String, Object> emprestimo) {
        Aluno aluno = alunoService.findByID(UUID.fromString(emprestimo.get("idpessoa").toString()));
        List<Livro> livros = new ArrayList<>();
        for (String idLivro :
                (List<String>) emprestimo.get("livros")) {
            Livro livro = livroService.findByID(UUID.fromString(idLivro));
            if(livro.getQuantidade() > 0){
                livro.setQuantidade(livro.getQuantidade()-1);
                livros.add(livro);
                Emprestimo em = new Emprestimo();
                em.setPessoa(aluno);
                em.setLivro(livros);
                em.setDataEmprestimo(LocalDate.now());
                return emprestimoRepository.save(em);
            }
        }
        return null;
    }

    public Emprestimo findByID(UUID id){
        Optional<Emprestimo> emprestimo = emprestimoRepository.findById(id);
        return emprestimo.orElseThrow(() -> new RuntimeException("Emprestimo não localizado"));
    }

    public List<Emprestimo> findByNamePessoa(String pessoa){
        return emprestimoRepository.findByNome(pessoa);

    }

}
