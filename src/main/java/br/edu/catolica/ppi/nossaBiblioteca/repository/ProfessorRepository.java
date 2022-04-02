package br.edu.catolica.ppi.nossaBiblioteca.repository;

import br.edu.catolica.ppi.nossaBiblioteca.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ProfessorRepository extends JpaRepository <Professor, UUID> {

    Professor findByCpf(String cpf);

    @Query("select p.nome from Professor p where p.nome like %:nome%")
    String findByNome(String nome);
}
