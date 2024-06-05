package br.com.luds.Luds.cliente.model.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class ClienteForm {
    private UUID id;
    @NotNull(message = "Nome do Cliente não informado")
    private String nome;
    @NotNull(message = "Telefone do Cliente não informado")
    private String telefone;

    private String telefoneAlternativo;
    @NotNull(message = "Endereco do Cliente não informado")
    private String endereco;
    @NotNull(message = "Data Nascimento do Cliente não informado")
    private LocalDate dataNascimento;
}
