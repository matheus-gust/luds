package br.com.luds.Luds.cliente.application;

import br.com.luds.Luds.cliente.model.assembler.ClienteAssembler;
import br.com.luds.Luds.cliente.model.dto.ClienteDTO;
import br.com.luds.Luds.cliente.model.form.ClienteForm;
import br.com.luds.Luds.cliente.service.ClienteService;
import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ClienteApplication {

    private final ClienteService clienteService;
    private final ClienteAssembler clienteAssembler;

    public ApiCollectionResponse<ClienteDTO> listarUnidadeMedidas(ApiPageRequest pageRequest) {
        Page pageUnidadeMedida = this.clienteService.listarUnidadeMedidas(pageRequest);
        return clienteAssembler.assembleManyDTO(pageUnidadeMedida.toList(), pageRequest.getPage(), pageRequest.getPageSize(), pageUnidadeMedida.hasNext());
    }

    public ClienteDTO buscarUnidadeMedidaPorId(UUID id) {
        return this.clienteAssembler.assembleDTO(this.clienteService.buscarUnidadeMedidaPorId(id));
    }

    public ClienteDTO inserirUnidadeMedida(ClienteForm cliente) {
        return this.clienteAssembler.assembleDTO(this.clienteService.inserirUnidadeMedida(this.clienteAssembler.assembleEntity(cliente)));
    }

    public ClienteDTO alterarUnidadeMedida(UUID id, ClienteForm cliente) {
        return this.clienteAssembler.assembleDTO(this.clienteService.alterarUnidadeMedida(id, this.clienteAssembler.assembleEntity(cliente)));
    }

    public void removerUnidadeMedida(UUID id) {
        this.clienteService.removerUnidadeMedida(id);
    }
}
