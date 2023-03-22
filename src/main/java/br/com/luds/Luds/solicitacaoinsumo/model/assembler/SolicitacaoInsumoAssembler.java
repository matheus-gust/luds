package br.com.luds.Luds.solicitacaoinsumo.model.assembler;

import br.com.luds.Luds.commons.model.ILudzAssembler;
import br.com.luds.Luds.insumo.model.Insumo;
import br.com.luds.Luds.insumo.service.InsumoService;
import br.com.luds.Luds.solicitacaoinsumo.model.SolicitacaoInsumo;
import br.com.luds.Luds.solicitacaoinsumo.model.dto.SolicitacaoInsumoDTO;
import br.com.luds.Luds.solicitacaoinsumo.model.form.SolicitacaoInsumoForm;
import br.com.luds.Luds.unidade.model.Unidade;
import br.com.luds.Luds.unidade.service.UnidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class SolicitacaoInsumoAssembler implements ILudzAssembler<SolicitacaoInsumo, SolicitacaoInsumoDTO, SolicitacaoInsumoForm> {

    private final UnidadeService unidadeService;
    private final InsumoService insumoService;
    @Override
    public SolicitacaoInsumoDTO assembleDTO(SolicitacaoInsumo entity) {
        return new SolicitacaoInsumoDTO(entity.getId(), entity.getQuantidadeSolicitada().toString(), entity.getUnidade(), entity.getInsumo());
    }

    @Override
    public SolicitacaoInsumo assembleEntity(SolicitacaoInsumoForm solicitacaoInsumoForm) {
        Unidade unidade = unidadeService.buscarUnidadePorId(solicitacaoInsumoForm.getUnidade());
        Insumo insumo = insumoService.buscarInsumoPorId(solicitacaoInsumoForm.getInsumo());
        return new SolicitacaoInsumo(null, new BigDecimal(solicitacaoInsumoForm.getQuantidadeSolicitada()), unidade, insumo);
    }
}
