package br.com.luds.Luds.cliente.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private UUID id;
    private String nome;
    private String telefone;
    private String telefoneAlternativo;
    private String endereco;
    private String dataNascimento;
}
