package com.api.challenge.foro.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findByActivoTrue(Pageable paginacion);

    @Query("""
            select t.status from Topico t
            where t.id = :idTopico
            """)
    boolean findStatusById(Long idTopico);
    boolean existsByTituloIgnoreCase(String titulo);
    boolean existsByMensajeIgnoreCase(String mensaje);

}
