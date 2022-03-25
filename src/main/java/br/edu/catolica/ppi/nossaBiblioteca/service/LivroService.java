package br.edu.catolica.ppi.nossaBiblioteca.service;

import br.edu.catolica.ppi.nossaBiblioteca.model.Livro;
import br.edu.catolica.ppi.nossaBiblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired //Injetando a classe repository
    LivroRepository livroRepository;

    public Livro saveOrUpdate(Livro livro){
       return livroRepository.save(livro);
    }

    public List<Livro> getAllLivro(){
        return livroRepository.findAll();
    }


}
