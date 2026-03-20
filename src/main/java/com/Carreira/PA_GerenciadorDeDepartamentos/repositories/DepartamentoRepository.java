package com.Carreira.PA_GerenciadorDeDepartamentos.repositories;


import com.Carreira.PA_GerenciadorDeDepartamentos.models.DepartamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<DepartamentoModel, Long> {
}
