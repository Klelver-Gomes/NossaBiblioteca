package br.edu.catolica.ppi.nossaBiblioteca.repository;

import br.edu.catolica.ppi.nossaBiblioteca.model.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, UUID> {

    Bibliotecario findByCpf(String cpf);

    @Query("select a.nome from Bibliotecario a where a.nome like %:nome%")
    String findByNome(String nome);


}
