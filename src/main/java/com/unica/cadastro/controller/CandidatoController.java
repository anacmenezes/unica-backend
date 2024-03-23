package com.unica.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unica.cadastro.domain.Candidato;
import com.unica.cadastro.dto.CandidatoResponseDTO;
import com.unica.cadastro.repositories.CandidatoRepository;
import com.unica.cadastro.service.CandidatoService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/candidato", produces = { "application/json" })
@Tag(name = "candidato")
public class CandidatoController {

	@Autowired
	private CandidatoRepository repo;

	private CandidatoService service;

	public CandidatoController(CandidatoService service) {
		this.service = service;
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public List<CandidatoResponseDTO> findAll() {

		List<CandidatoResponseDTO> candidatoList = repo.findAll().stream().map(CandidatoResponseDTO::new).toList();
		return candidatoList;
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/{cod}")
	public ResponseEntity<List<CandidatoResponseDTO>> find(@PathVariable Long cod) {
		List<CandidatoResponseDTO> candidatoList = repo.findById(cod).stream().map(CandidatoResponseDTO::new).toList();
		return ResponseEntity.ok().body(candidatoList);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public ResponseEntity<String> saveCandidato(@RequestBody Candidato candidato) {
		try {
			service.save(candidato);
			return ResponseEntity.ok("Candidato salvo com sucesso.");
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/{cod}")
    public ResponseEntity<String> updateCandidato(@PathVariable Long cod, @RequestBody Candidato candidato) {
        try {
            service.update(cod, candidato);
            return ResponseEntity.ok("Candidato atualizado com sucesso.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/{cod}")
	public ResponseEntity<Void> delete(@PathVariable Long cod) {
		repo.deleteById(cod);
		return ResponseEntity.noContent().build();
	}
}