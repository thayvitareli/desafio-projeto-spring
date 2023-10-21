package thainyvitareli.desafioprojetospring.service;

import org.springframework.stereotype.Component;
import thainyvitareli.desafioprojetospring.model.Cliente;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Component
public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Optional<Cliente> buscarPorId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);

}
