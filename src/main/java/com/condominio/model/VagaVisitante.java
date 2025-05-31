package com.condominio.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class VagaVisitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDate data;
    
    @Column(name = "hora_inicio")
    private LocalTime horaInicio;
    
    @Column(name = "hora_fim")
    private LocalTime horaFim;
    
    private int vagasTotais;
    private int vagasDisponiveis;
    
    @ManyToOne
    @JoinColumn(name = "morador_id")
    private Morador moradorReserva;
    
    

	public VagaVisitante(Long id, LocalDate data, LocalTime horaInicio, LocalTime horaFim, int vagasTotais,
		int vagasDisponiveis, Morador moradorReserva) {
		this.id = id;
		this.data = data;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.vagasTotais = vagasTotais;
		this.vagasDisponiveis = vagasDisponiveis;
		this.moradorReserva = moradorReserva;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(LocalTime horaFim) {
		this.horaFim = horaFim;
	}

	public int getVagasTotais() {
		return vagasTotais;
	}

	public void setVagasTotais(int vagasTotais) {
		this.vagasTotais = vagasTotais;
	}

	public int getVagasDisponiveis() {
		return vagasDisponiveis;
	}

	public void setVagasDisponiveis(int vagasDisponiveis) {
		this.vagasDisponiveis = vagasDisponiveis;
	}

	public Morador getMoradorReserva() {
		return moradorReserva;
	}

	public void setMoradorReserva(Morador moradorReserva) {
		this.moradorReserva = moradorReserva;
	}
    
    
    
    // Getters e Setters
    // Construtores
}