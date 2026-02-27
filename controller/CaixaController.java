
package com.info.controller;
import com.info.model.Movimento;
import com.info.repository.MovimentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/caixa"})
public class CaixaController {
    
    @Autowired
    MovimentoRepository mr;
    
 //tela movimento:
    @GetMapping("/novo")
    public String novoMovimento(Model model){
        Movimento movimento=new Movimento();
        model.addAttribute("movimento",movimento);
        return "paginas/form-movimento";
    }
    
    @PostMapping("/salvar")
    public String salvaVenda(@ModelAttribute("movimento") Movimento caixa){
        mr.save(caixa);
        return "redirect:/movimento/";
    }
    
    
 //tela saldo:
   // @GetMapping("/saldo")
    public String mostrarSaldo(Model model) {//
        List<Movimento> lista = mr.findAll();
        double total = 0;
        for (Movimento m : lista) {
            if (m.getTipo().equalsIgnoreCase("ENTRADA")) {
                total += m.getValor();
            } else {
                total -= m.getValor();
            }
        }
        model.addAttribute("lista", lista);
        model.addAttribute("total", total);
        return "paginas/saldo";
    }//
}

