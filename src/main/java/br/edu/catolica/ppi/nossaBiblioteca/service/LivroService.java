package br.edu.catolica.ppi.nossaBiblioteca.service;

import br.edu.catolica.ppi.nossaBiblioteca.model.Livro;
import br.edu.catolica.ppi.nossaBiblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Livro findByISBN(int isbn){
        return livroRepository.findByISBN(isbn);
    }

    public String findByName(String nome){
        return livroRepository.findByNome(nome);
    }

    public Livro findByID(UUID id){
        Optional <Livro> livro = livroRepository.findById(id);
        return livro.orElseThrow(() -> new RuntimeException("Livro não localizado"));
    }

    public void remove (Livro livro){
        Livro l = findByID(livro.getId());
        livroRepository.delete(l);
    }


}
