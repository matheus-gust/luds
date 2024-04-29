package br.com.luds.Luds.contasapagar.service;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.SimNaoEnum;
import br.com.luds.Luds.contasapagar.exception.ContasPagarNaoEncontradaException;
import br.com.luds.Luds.contasapagar.model.ContasPagar;
import br.com.luds.Luds.contasapagar.repository.ContasPagarRepository;
import br.com.luds.Luds.formapagamento.model.FormaPagamento;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ContasPagarService {

    private final ContasPagarRepository contasPagarRepository;

    public ContasPagar buscarContasPagarPorId(UUID id) {
        if(Objects.isNull(id)) {
            throw new ContasPagarNaoEncontradaException();
        }
        return this.contasPagarRepository.findById(id).orElseThrow(() -> new ContasPagarNaoEncontradaException());
    }

    public Page<ContasPagar> listarContasPagars(ApiPageRequest pageRequest) {
        return this.contasPagarRepository.findAllOrderedByDataAsc(pageRequest.setPage());
    }

    public ContasPagar inserirContasPagar(ContasPagar contasPagar) {
        contasPagar.setPago(SimNaoEnum.NAO.getCod());
        return this.contasPagarRepository.save(contasPagar);
    }

    public ContasPagar alterarContasPagar(UUID id, ContasPagar contasPagar) {
        ContasPagar contasPagarContasPagarAtualizade = this.buscarContasPagarPorId(id);
        contasPagarContasPagarAtualizade.atualiza(contasPagar);
        return this.contasPagarRepository.save(contasPagarContasPagarAtualizade);
    }

    public void removerContasPagar(UUID id) {
        ContasPagar contasPagar = this.buscarContasPagarPorId(id);
        this.contasPagarRepository.delete(contasPagar);
    }

    public void marcaContaPago(UUID idConta, FormaPagamento formaPagamento) {
        ContasPagar contaPagar = this.buscarContasPagarPorId(idConta);
        contaPagar.setPago(SimNaoEnum.SIM.getCod());
        contaPagar.setFormaPagamento(formaPagamento);
        this.contasPagarRepository.save(contaPagar);
    }
}
