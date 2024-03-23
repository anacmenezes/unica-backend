package com.unica.cadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unica.cadastro.domain.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
	
	boolean existsById(Long cod);
}