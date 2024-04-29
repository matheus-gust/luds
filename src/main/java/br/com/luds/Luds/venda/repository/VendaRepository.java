package br.com.luds.Luds.venda.repository;

import br.com.luds.Luds.venda.model.Venda;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public interface VendaRepository extends JpaRepository<Venda, UUID> {
    default Page<Venda> findAllOrderedByDataDesc(Pageable pageable) {
        Page<Venda> page = findAll(pageable);
        List<Venda> sortedList = page.getContent().stream()
                .sorted((c1, c2) -> compareDates(c2.getData(), c1.getData()))
                .collect(Collectors.toList());
        return new PageImpl<>(sortedList, pageable, page.getTotalElements());
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
