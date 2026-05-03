package com.processo.api.repository;

import com.processo.api.model.Processo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProcessoRepository extends JpaRepository<Processo, Long>{ //representa repositorio p/ entidade Processo com chave primaria Long

}
