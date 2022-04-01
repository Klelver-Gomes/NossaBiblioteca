package br.edu.catolica.ppi.nossaBiblioteca.model;


import br.edu.catolica.ppi.nossaBiblioteca.enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Bibliotecario extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;



}
