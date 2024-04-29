package br.com.luds.Luds.venda.service;

import br.com.luds.Luds.venda.model.Parte;
import br.com.luds.Luds.venda.model.Venda;
import br.com.luds.Luds.venda.model.VendaItemCardapio;
import br.com.luds.Luds.venda.model.assembler.VendaItemCardapioAssembler;
import br.com.luds.Luds.venda.model.form.ParteIn;
import br.com.luds.Luds.venda.repository.ParteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParteService {
    private final ParteRepository parteRepository;
    private final VendaItemCardapioAssembler vendaItemCardapioAssembler;

    public List<Parte> deltaDeitens(List<ParteIn> partes, Venda venda) {
        List<Parte> antigosRelacionamentos = this.listarRelacoesPorIdParteEm(venda.getId());

        List<Parte> novosRelacionamentos = new ArrayList<>();
        partes.forEach(parteCard -> {
            Parte parte = new Parte(null, parteCard.getNome(), parteCard.getValorParte(), venda, new ArrayList<>());
            List<VendaItemCardapio> itens = parteCard.getItens().stream().map(item -> vendaItemCardapioAssembler.assembleEntity(item, parte)).collect(Collectors.toList());
            parte.setItens(itens);
            novosRelacionamentos.add(parte);
        });

        for (Parte item : antigosRelacionamentos) {
            this.parteRepository.delete(item);
        }
        return novosRelacionamentos;
    }

    public List<Parte> listarRelacoesPorIdParteEm(UUID id) {
        return this.parteRepository.findAllByVendaId(id);
    }
}
