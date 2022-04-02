package br.edu.catolica.ppi.nossaBiblioteca.service;

import br.edu.catolica.ppi.nossaBiblioteca.model.Professor;
import br.edu.catolica.ppi.nossaBiblioteca.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProfessorService {

    private  final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Professor saveOrUpdate(Professor professor){
        return  professorRepository.save(professor);
    }

    public Professor findById(UUID id){
        Optional <Professor> professor = professorRepository.findById(id);
        return professor.orElseThrow(() -> new RuntimeException("Professor não encontrado"));
    }

    public String findByNome(String nome){
        return professorRepository.findByNome(nome);
    }

    public Professor findByCpf(String cpf){
        return professorRepository.findByCpf(cpf);
    }

    public List<Professor> getAll(){
        return professorRepository.findAll();
    }


    public void remove (Professor professor){
        Professor p = findById(professor.getId());
        professorRepository.delete(p);
    }


}
