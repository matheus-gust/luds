package br.com.luds.Luds.venda.model.assembler;

import br.com.luds.Luds.commons.model.ILudzAssembler;
import br.com.luds.Luds.venda.model.Parte;
import br.com.luds.Luds.venda.model.dto.ParteVendaDTO;
import br.com.luds.Luds.venda.model.dto.VendaItemCardapioDTO;
import br.com.luds.Luds.venda.model.form.ParteIn;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ParteVendaAssembler implements ILudzAssembler<Parte, ParteVendaDTO, ParteIn> {

    private final VendaItemCardapioAssembler vendaItemCardapioAssembler;

    @Override
    public ParteVendaDTO assembleDTO(Parte entity) {
        List<VendaItemCardapioDTO> itens = vendaItemCardapioAssembler.assembleManyDTO(entity.getItens());
        return new ParteVendaDTO(entity.getId(), entity.getNome(), entity.getValorParte(), null, itens);
    }

    @Override
    public Parte assembleEntity(ParteIn parteIn) {
        return new Parte(null, parteIn.getNome(), parteIn.getValorParte(), null, new ArrayList<>());
    }
}
