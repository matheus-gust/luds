package br.com.luds.Luds.commons.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiCollectionResponse<T> {
    private List<T> items;
    private boolean next;

    public boolean hasNext() {
        return this.hasNext();
    }
}
