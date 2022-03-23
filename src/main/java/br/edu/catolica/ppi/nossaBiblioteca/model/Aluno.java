package br.edu.catolica.ppi.nossaBiblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Aluno extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String curso;
    private int periodo;

}
