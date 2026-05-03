package com.processo.api.repository;

import com.processo.api.model.Processo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProcessoRepository extends JpaRepository<Processo, Long>{ //representa repositorio p/ entidade Processo com chave primaria Long
    @Query("SELECT p FROM Processo p WHERE LOWER(p.cliente.nomeCliente) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Processo> buscarPorNomeCliente(@Param("nome") String nome);

    @Query("SELECT p FROM Processo p WHERE CAST(p.nProcesso AS string) LIKE CONCAT('%', :numero, '%')")
    List<Processo> buscarPorNumero(@Param("numero") String numero);
}
