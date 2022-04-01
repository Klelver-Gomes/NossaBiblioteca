package br.edu.catolica.ppi.nossaBiblioteca.repository;

import br.edu.catolica.ppi.nossaBiblioteca.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno , UUID> {

    Aluno findByCpf(String cpf);

    @Query("select a.nome from Aluno a where a.nome like %:nome%")
    String findByNome(String nome);
}
