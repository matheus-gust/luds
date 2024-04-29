package br.com.luds.Luds.insumo.model.assembler;

import br.com.luds.Luds.commons.model.ILudzAssembler;
import br.com.luds.Luds.fornecedor.model.Fornecedor;
import br.com.luds.Luds.fornecedor.model.assembler.FornecedorAssembler;
import br.com.luds.Luds.fornecedor.service.FornecedorService;
import br.com.luds.Luds.insumo.model.Insumo;
import br.com.luds.Luds.insumo.model.dto.InsumoDTO;
import br.com.luds.Luds.insumo.model.form.InsumoForm;
import br.com.luds.Luds.unidade.model.assembler.UnidadeAssembler;
import br.com.luds.Luds.unidadedemedida.model.UnidadeMedida;
import br.com.luds.Luds.unidadedemedida.model.assembler.UnidadeMedidaAssembler;
import br.com.luds.Luds.unidadedemedida.service.UnidadeMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsumoAssembler implements ILudzAssembler<Insumo, InsumoDTO, InsumoForm> {

    @Autowired
    private FornecedorService fornecedorService;
    @Autowired
    private UnidadeMedidaService unidadeMedidaService;
    @Autowired
    private FornecedorAssembler fornecedorAssembler;
    @Autowired
    private UnidadeMedidaAssembler unidadeAssembler;

    @Override
    public InsumoDTO assembleDTO(Insumo entity) {
        return new InsumoDTO(entity.getId(), entity.getCodigo(), entity.getNome(), unidadeAssembler.assembleDTO(entity.getUnidadeMedida()));
    }

    @Override
    public Insumo assembleEntity(InsumoForm insumoForm) {
        UnidadeMedida unimedida = this.unidadeMedidaService.buscarUnidadeMedidaPorId(insumoForm.getUnidadeMedida().getId());
        return new Insumo(null, insumoForm.getCodigo(), insumoForm.getNome(), unimedida);
    }
}
