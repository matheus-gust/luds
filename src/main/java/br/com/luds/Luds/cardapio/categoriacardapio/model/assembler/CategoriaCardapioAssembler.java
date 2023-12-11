package br.com.luds.Luds.cardapio.categoriacardapio.model.assembler;

import br.com.luds.Luds.cardapio.categoriacardapio.model.CategoriaCardapio;
import br.com.luds.Luds.cardapio.categoriacardapio.model.dto.CategoriaCardapioDTO;
import br.com.luds.Luds.cardapio.categoriacardapio.model.form.CategoriaCardapioForm;
import br.com.luds.Luds.commons.model.ILudzAssembler;
import org.springframework.stereotype.Component;

@Component
public class CategoriaCardapioAssembler implements ILudzAssembler<CategoriaCardapio, CategoriaCardapioDTO, CategoriaCardapioForm> {
    @Override
    public CategoriaCardapioDTO assembleDTO(CategoriaCardapio entity) {
        return new CategoriaCardapioDTO(entity.getId(), entity.getNome());
    }

    @Override
    public CategoriaCardapio assembleEntity(CategoriaCardapioForm categoriaCardapioForm) {
        return new CategoriaCardapio(null, categoriaCardapioForm.getNome());
    }
}
