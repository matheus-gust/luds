package br.com.luds.Luds.fornecedor.model.assembler;

import br.com.luds.Luds.commons.model.ILudzAssembler;
import br.com.luds.Luds.fornecedor.model.Fornecedor;
import br.com.luds.Luds.fornecedor.model.dto.FornecedorDTO;
import br.com.luds.Luds.fornecedor.model.form.FornecedorForm;
import org.springframework.stereotype.Component;

@Component
public class FornecedorAssembler implements ILudzAssembler<Fornecedor, FornecedorDTO, FornecedorForm> {
    @Override
    public FornecedorDTO assembleDTO(Fornecedor entity) {
        return new FornecedorDTO(entity.getId(), entity.getCodigo(), entity.getNome(), entity.getDiaEntregaPrev(), entity.getDiaEntregaSemana(), entity.getEndereco());
    }

    @Override
    public Fornecedor assembleEntity(FornecedorForm fornecedorForm) {
        return new Fornecedor(null, fornecedorForm.getCodigo(), fornecedorForm.getNome(), fornecedorForm.getDiaEntregaPrev(), fornecedorForm.getDiaEntregaSemana(), fornecedorForm.getEndereco());
    }
}
