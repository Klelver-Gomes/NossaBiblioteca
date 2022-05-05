package br.edu.catolica.ppi.nossaBiblioteca.repository;

import br.edu.catolica.ppi.nossaBiblioteca.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, UUID> {

    @Query("select e from Emprestimo e where e.pessoa.nome like %:nome%")
    List<Emprestimo> findByNome(String nome);
}
