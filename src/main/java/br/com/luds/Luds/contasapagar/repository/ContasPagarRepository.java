package br.com.luds.Luds.contasapagar.repository;

import br.com.luds.Luds.contasapagar.model.ContasPagar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public interface ContasPagarRepository extends JpaRepository<ContasPagar, UUID> {

    default Page<ContasPagar> findAllOrderedByDataAsc(Pageable pageable) {
        Page<ContasPagar> page = findAll(pageable);
        List<ContasPagar> contaPagar = page.getContent().stream()
                .sorted((c1, c2) -> compareDates(c1.getDataVencimento(), c2.getDataVencimento()))
                .collect(Collectors.toList());

        return new PageImpl<>(contaPagar, pageable, page.getTotalElements());
    }

    private int compareDates(String date1, String date2) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date d1 = dateFormat.parse(date1);
            Date d2 = dateFormat.parse(date2);
            return d1.compareTo(d2);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
