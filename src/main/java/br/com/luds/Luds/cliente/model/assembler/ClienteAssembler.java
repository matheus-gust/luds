package br.com.luds.Luds.cliente.model.assembler;

import br.com.luds.Luds.cliente.model.Cliente;
import br.com.luds.Luds.cliente.model.dto.ClienteDTO;
import br.com.luds.Luds.cliente.model.form.ClienteForm;
import br.com.luds.Luds.commons.model.ILudzAssembler;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class ClienteAssembler implements ILudzAssembler<Cliente, ClienteDTO, ClienteForm> {
    @Override
    public ClienteDTO assembleDTO(Cliente entity) {
        return new ClienteDTO(entity.getId(), entity.getNome(), entity.getTelefone(), entity.getTelefoneAlternativo(), entity.getEndereco(), entity.getDataNascimento());
    }

    @Override
    public Cliente assembleEntity(ClienteForm clienteForm) {
        return new Cliente(null, clienteForm.getNome(), clienteForm.getTelefone(), clienteForm.getTelefoneAlternativo(), clienteForm.getEndereco(), clienteForm.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
