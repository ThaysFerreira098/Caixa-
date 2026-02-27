
package com.info.contato.service;
import com.info.contato.model.Contato;
import com.info.contato.repository.ContatoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {
    @Autowired
   ContatoRepository contatoRepository;

    public Contato localizar(int id){
        Optional<Contato> contatoBusca = contatoRepository.findById(id);
        if (contatoBusca.isPresent()) {
            return contatoBusca.get();
        } else {
            return null;
        }
    }
    public List<Contato> pesquisar() {
        return contatoRepository.findAll();
    }

    public Contato salvar(Contato contato) {
        return contatoRepository.save(contato);
    }

    public void excluir(int id) {
        contatoRepository.deleteById(id);
    }
}
