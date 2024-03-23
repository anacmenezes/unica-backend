package com.unica.cadastro.dto;

import com.unica.cadastro.domain.Candidato;

public record CandidatoResponseDTO (Long cod, String name, Integer phone){
	 public CandidatoResponseDTO(Candidato candidato){
	        this(candidato.getCod(), candidato.getName(), candidato.getPhone());
	    }
}