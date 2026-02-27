
package com.info.contato.controller;
import com.info.contato.model.Contato;
import com.info.contato.service.ContatoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contato")
public class ContatoController {
    
    @Autowired
    ContatoService contatoService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Contato> localizar(@PathVariable int id){
        return ResponseEntity.ok(contatoService.localizar(id));
    }
    @GetMapping()
    public ResponseEntity<List<Contato>> pesquisar() {
        return ResponseEntity.ok(contatoService.pesquisar());
    }

    @PostMapping()
    public ResponseEntity<Contato> salvar(@RequestBody Contato contato) {
        return ResponseEntity.ok(contatoService.salvar(contato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable int id) {
        try {
            contatoService.excluir(id);
            return ResponseEntity.ok("Contato " + id + " excluído!");
        } catch (Exception e) {
            return ResponseEntity.ok("Erro ao excluir o Contato " + id + ": " + e.getMessage());
        }
    }
}
