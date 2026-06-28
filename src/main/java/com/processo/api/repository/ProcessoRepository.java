package com.processo.api.repository;

import com.processo.api.model.Processo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProcessoRepository extends JpaRepository<Processo, Long> {
    @Query("SELECT p FROM Processo p WHERE p.nProcesso = :nProcesso")
    List<Processo> findByNProcesso(@Param("nProcesso") int nProcesso);

    List<Processo> findByClienteNomeContainingIgnoreCase(String nome);

    @Modifying
    @Query("DELETE FROM Processo p WHERE p.id = :id")
    void deletarPorIdDirect(@Param("id") Long id);
}