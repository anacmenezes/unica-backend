package com.unica.cadastro.domain;

import com.unica.cadastro.dto.CandidatoRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity(name = "foods")
@Table(name = "candidato")
@EqualsAndHashCode(of = "id")
public class Candidato {

	@Id
	private Long cod;
	private String name;
	private Integer phone;

	public Candidato() {
	}

	public Candidato(CandidatoRequestDTO data) {
		this.cod = data.cod();
		this.name = data.name();
		this.phone = data.phone();
	}

	public Long getCod() {
		return cod;
	}

	public void setCod(Long cod) {
		this.cod = cod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}
}