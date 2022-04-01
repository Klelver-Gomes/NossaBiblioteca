package br.edu.catolica.ppi.nossaBiblioteca.enums;

import javax.persistence.Embeddable;
import java.util.Arrays;


public enum Genero {

    Masculino(1),
    Feminino(2);

    private Integer valor;

    Genero(Integer valor) {
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }

    public static Genero getGenero(Integer codigo){
        return Arrays.stream(Genero.values())
                .filter(e -> e.getValor().equals(codigo))
                .findFirst()
                .orElse(null);
    }
}
