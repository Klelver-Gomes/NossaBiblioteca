package br.edu.catolica.ppi.nossaBiblioteca.service;

import br.edu.catolica.ppi.nossaBiblioteca.model.Bibliotecario;
import br.edu.catolica.ppi.nossaBiblioteca.repository.BibliotecarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BibliotecarioService {

    private final BibliotecarioRepository bibliotecarioRepository;

    public BibliotecarioService(BibliotecarioRepository bibliotecarioRepository) {
        this.bibliotecarioRepository = bibliotecarioRepository;
    }

    public Bibliotecario saveOrUpdate(Bibliotecario bibliotecario){
        return bibliotecarioRepository.save(bibliotecario);
    }

    public Bibliotecario findByID(UUID id){
        Optional<Bibliotecario> bibliotecario = bibliotecarioRepository.findById(id);
        return bibliotecario.orElseThrow(() -> new RuntimeException("Bibliotecario não localizado"));
    }

    public Bibliotecario findByCpf (String cpf){
        return bibliotecarioRepository.findByCpf(cpf);
    }

    public String FindByNome (String nome){
        return bibliotecarioRepository.findByNome(nome);
    }

    public List<Bibliotecario> getAll(){
        return bibliotecarioRepository.findAll();
    }

    public void remove(Bibliotecario bibliotecario){
        Bibliotecario a = findByID(bibliotecario.getId());
        bibliotecarioRepository.delete(a);
    }
}
