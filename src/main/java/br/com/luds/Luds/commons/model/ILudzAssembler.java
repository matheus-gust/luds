package br.com.luds.Luds.commons.model;

import java.util.List;
import java.util.stream.Collectors;

public interface ILudzAssembler<T, DTO, FORM>{
        DTO assembleDTO(T entity);
        T assembleEntity(FORM form);

        default List<DTO> assembleManyDTO(List<T> entities) {
            return entities.stream().map(entity -> assembleDTO(entity)).collect(Collectors.toList());
        }

        default ApiCollectionResponse<DTO> assembleManyDTO(ApiCollectionResponse<T> collection) {
            List<DTO> dtos = collection.getItems().stream().map(entity -> assembleDTO(entity)).collect(Collectors.toList());
            return new ApiCollectionResponse(dtos, collection.hasNext());
        }
}
