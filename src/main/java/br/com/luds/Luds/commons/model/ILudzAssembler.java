package br.com.luds.Luds.commons.model;

import java.util.List;
import java.util.stream.Collectors;

public interface ILudzAssembler<T, DTO, FORM>{
        DTO assembleDTO(T entity);
        T assembleEntity(FORM form);

        default List<DTO> assembleManyDTO(List<T> entities) {
            return entities.stream().map(entity -> assembleDTO(entity)).collect(Collectors.toList());
        }

        default ApiCollectionResponse<DTO> assembleManyDTO(List<T> collection, Integer page, Integer pageSize, boolean hasNext) {
            List<DTO> dtos = collection.stream().map(entity -> assembleDTO(entity)).collect(Collectors.toList());
            return new ApiCollectionResponse(dtos, page, pageSize, hasNext);
        }
}
