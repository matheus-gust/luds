package br.com.luds.Luds.venda.model.assembler;

import br.com.luds.Luds.commons.model.ILudzAssembler;
import br.com.luds.Luds.venda.model.Venda;
import br.com.luds.Luds.venda.model.VendaItemCardapio;
import br.com.luds.Luds.venda.model.dto.VendaDTO;
import br.com.luds.Luds.venda.model.dto.VendaItemCardapioDTO;
import br.com.luds.Luds.venda.model.form.VendaForm;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class VendaAssembler implements ILudzAssembler<Venda, VendaDTO, VendaForm> {

    private final VendaItemCardapioAssembler vendaItemCardapioAssembler;

    @Override
    public VendaDTO assembleDTO(Venda entity) {
        List<VendaItemCardapioDTO> vendaItemCardapioDTOS = vendaItemCardapioAssembler.assembleManyDTO(entity.getItens());
        return new VendaDTO(entity.getId(), entity.getBoletim(), entity.getData(), entity.getOrigem(), entity.getValor(), vendaItemCardapioDTOS);
    }

    @Override
    public Venda assembleEntity(VendaForm vendaForm) {
        return new Venda(null, null, vendaForm.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), vendaForm.getOrigem(), vendaForm.getValor(), new ArrayList<>());
    }
}
