package br.edu.catolica.ppi.nossaBiblioteca.service;

import br.edu.catolica.ppi.nossaBiblioteca.model.Aluno;
import br.edu.catolica.ppi.nossaBiblioteca.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno saveOrUpdate(Aluno aluno){
        return alunoRepository.save(aluno);
    }
}
