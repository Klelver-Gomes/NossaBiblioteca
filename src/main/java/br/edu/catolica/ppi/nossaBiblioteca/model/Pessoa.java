package br.edu.catolica.ppi.nossaBiblioteca.model;

import br.edu.catolica.ppi.nossaBiblioteca.enums.Genero;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)


public abstract class Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private int matricula;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    private String nome;

    @Column(unique = true)
    private String cpf;


    @Embedded
    private Endereco endereco;

    @Embedded
    private Contato contato;


    private Integer genero;

}
