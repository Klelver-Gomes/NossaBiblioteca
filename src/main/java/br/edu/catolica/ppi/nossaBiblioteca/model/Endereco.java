package br.edu.catolica.ppi.nossaBiblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {

    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String uf;

}
