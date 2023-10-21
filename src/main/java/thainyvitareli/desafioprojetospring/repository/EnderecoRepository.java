package thainyvitareli.desafioprojetospring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thainyvitareli.desafioprojetospring.model.Cliente;
import thainyvitareli.desafioprojetospring.model.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
