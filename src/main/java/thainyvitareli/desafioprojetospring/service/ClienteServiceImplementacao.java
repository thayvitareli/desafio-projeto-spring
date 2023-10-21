package thainyvitareli.desafioprojetospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import thainyvitareli.desafioprojetospring.model.Cliente;
import thainyvitareli.desafioprojetospring.model.Endereco;
import thainyvitareli.desafioprojetospring.repository.ClienteRepository;
import thainyvitareli.desafioprojetospring.repository.EnderecoRepository;

import java.util.*;

@Component
public class ClienteServiceImplementacao implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        if(clienteRepository.findAll().equals(null)){
            return null;
        }
        return  clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
     Optional<Cliente> clienteId = clienteRepository.findById(id);
        if(clienteId.equals(null)){
            return null;
        }
        return Optional.of(clienteId.get());
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if(clienteBd.isPresent()){
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente){
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
                Endereco enderecoNovo = viaCepService.consultarCep(cep);
                enderecoRepository.save(enderecoNovo);
                return  enderecoNovo;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);

    }
}
