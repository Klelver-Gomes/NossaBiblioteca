package br.edu.catolica.ppi.nossaBiblioteca.model;

import br.edu.catolica.ppi.nossaBiblioteca.enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Aluno extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String curso;
    private int periodo;

//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<Livro> livros;

}
