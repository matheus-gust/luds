package br.com.luds.Luds.commons.ludspage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiPageRequest {

    @Min(value = 1)
    private Integer pageSize = 8;
    private Integer page = 0;

    public Pageable setPage() {
        return PageRequest.of(this.page, this.pageSize);
    }
}
