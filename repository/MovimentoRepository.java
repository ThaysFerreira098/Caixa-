
package com.info.repository;
import com.info.model.Movimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentoRepository extends JpaRepository<Movimento, Integer>{
    // aqui tem que colocar o lib(1 linha)
}
