package br.edu.catolica.ppi.nossaBiblioteca.service;

import br.edu.catolica.ppi.nossaBiblioteca.model.Aluno;
import br.edu.catolica.ppi.nossaBiblioteca.repository.AlunoRepository;
import br.edu.catolica.ppi.nossaBiblioteca.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno saveOrUpdate(Aluno aluno){
//        aluno.setDataNascimento(DateUtil
//                .stringToLocalDate(aluno.getDataNascimento().toString()));
        return alunoRepository.save(aluno);
    }

    public Aluno findByID(UUID id){
      Optional<Aluno> aluno = alunoRepository.findById(id);
      return aluno.orElseThrow(() -> new RuntimeException("Aluno não localizado"));
    }

    public Aluno findByCpf (String cpf){
        return alunoRepository.findByCpf(cpf);
    }

    public String FindByNome (String nome){
        return alunoRepository.findByNome(nome);
    }

    public List<Aluno> getAll(){
        return alunoRepository.findAll();
    }
}
