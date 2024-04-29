package br.com.luds.Luds.compra.repository;

import br.com.luds.Luds.compra.model.Compra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public interface CompraRepository extends JpaRepository<Compra, UUID> {

    default Page<Compra> findAllOrderedByDataDesc(Pageable pageable) {
        Page<Compra> page = findAll(pageable);
        List<Compra> sortedList = page.getContent().stream()
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
