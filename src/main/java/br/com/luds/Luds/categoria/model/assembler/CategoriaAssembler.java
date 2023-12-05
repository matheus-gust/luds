package br.com.luds.Luds.categoria.model.assembler;

import br.com.luds.Luds.categoria.model.Categoria;
import br.com.luds.Luds.categoria.model.dto.CategoriaDTO;
import br.com.luds.Luds.categoria.model.form.CategoriaForm;
import br.com.luds.Luds.commons.model.ILudzAssembler;
import br.com.luds.Luds.fornecedor.model.Fornecedor;
import br.com.luds.Luds.fornecedor.service.FornecedorService;
import br.com.luds.Luds.unidadedemedida.model.UnidadeMedida;
import br.com.luds.Luds.unidadedemedida.service.UnidadeMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriaAssembler implements ILudzAssembler<Categoria, CategoriaDTO, CategoriaForm> {

    @Autowired
    private FornecedorService fornecedorService;
    @Autowired
    private UnidadeMedidaService unidadeMedidaService;
    @Override
    public CategoriaDTO assembleDTO(Categoria entity) {
        return new CategoriaDTO(entity.getId(), entity.getNome());
    }

    @Override
    public Categoria assembleEntity(CategoriaForm categoriaForm) {
        return new Categoria(null, categoriaForm.getNome());
    }
}
