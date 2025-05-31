package com.condominio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class VagaVisitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int semana;
    private LocalDate dataInicio;
    private String vaga1; // Apartamento que pode usar a vaga 1
    private String vaga2; // Apartamento que pode usar a vaga 2
    
    // Construtores, getters e setters
    public VagaVisitante() {}
    
    public VagaVisitante(int semana, LocalDate dataInicio, String vaga1, String vaga2) {
        this.semana = semana;
        this.dataInicio = dataInicio;
        this.vaga1 = vaga1;
        this.vaga2 = vaga2;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSemana() {
		return semana;
	}

	public void setSemana(int semana) {
		this.semana = semana;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getVaga1() {
		return vaga1;
	}

	public void setVaga1(String vaga1) {
		this.vaga1 = vaga1;
	}

	public String getVaga2() {
		return vaga2;
	}

	public void setVaga2(String vaga2) {
		this.vaga2 = vaga2;
	}
}