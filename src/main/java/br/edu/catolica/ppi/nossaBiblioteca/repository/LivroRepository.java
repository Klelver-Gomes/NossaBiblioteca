package br.edu.catolica.ppi.nossaBiblioteca.repository;

import br.edu.catolica.ppi.nossaBiblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LivroRepository extends JpaRepository<Livro , UUID> {
    Livro findByIsbn(Integer isbn);

    @Query("select a.nome from Livro a where a.nome like %:nome%")
    String findByNome(String nome);
}

