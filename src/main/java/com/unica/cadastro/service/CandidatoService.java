package com.unica.cadastro.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.unica.cadastro.domain.Candidato;
import com.unica.cadastro.repositories.CandidatoRepository;

@Service
public class CandidatoService {
	
    private final CandidatoRepository repo;

    public CandidatoService(CandidatoRepository repo) {
        this.repo = repo;
    }
	
	public List<Candidato> list(){
		Sort sort = Sort.by(Direction.DESC, "phone").and(Sort.by(Direction.ASC, "name"));
		return repo.findAll(sort);
	}
	
	public void update(Long cod, Candidato newCandidato) {
        Candidato existingCandidato = repo.findById(cod)
                .orElseThrow(() -> new IllegalArgumentException("Candidato não encontrado com o código fornecido."));
        existingCandidato.setName(newCandidato.getName());
        existingCandidato.setPhone(newCandidato.getPhone());

        repo.save(existingCandidato);
	}
	
    public Candidato save(Candidato candidato) {
        if (repo.existsById(candidato.getCod())) {
            throw new IllegalArgumentException("Candidato com o código fornecido já existe.");
        }
        return repo.save(candidato);
    }
}