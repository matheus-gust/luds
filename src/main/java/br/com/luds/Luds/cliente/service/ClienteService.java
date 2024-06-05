package br.com.luds.Luds.cliente.service;

import br.com.luds.Luds.cliente.exception.ClienteNaoEncontradaException;
import br.com.luds.Luds.cliente.model.Cliente;
import br.com.luds.Luds.cliente.repository.ClienteRepository;
import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente buscarUnidadeMedidaPorId(UUID id) {
        if(Objects.isNull(id)) {
            throw new ClienteNaoEncontradaException();
        }
        return this.clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoEncontradaException());
    }

    public Page<Cliente> listarUnidadeMedidas(ApiPageRequest pageRequest) {
        return this.clienteRepository.findAllOrderedByNomeAsc(pageRequest.setPage());
    }

    public Cliente inserirUnidadeMedida(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    public Cliente alterarUnidadeMedida(UUID id, Cliente cliente) {
        Cliente clienteUnidadeMedidaAtualizade = this.buscarUnidadeMedidaPorId(id);
        clienteUnidadeMedidaAtualizade.atualiza(cliente);
        return this.clienteRepository.save(clienteUnidadeMedidaAtualizade);
    }

    public void removerUnidadeMedida(UUID id) {
        Cliente cliente = this.buscarUnidadeMedidaPorId(id);
        this.clienteRepository.delete(cliente);
    }
}
