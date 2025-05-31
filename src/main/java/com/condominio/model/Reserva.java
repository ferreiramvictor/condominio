package com.condominio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String espaco; // "salao", "churrasqueira", "piscina"
    private LocalDate data;
    private String horario; // "08:00-10:00", etc
    private String status; // "Pendente", "Confirmado", "Cancelado"
    private Long moradorId;
    
    
    
    public Reserva(Long id, String espaco, LocalDate data, String horario, String status, Long moradorId) {
		this.id = id;
		this.espaco = espaco;
		this.data = data;
		this.horario = horario;
		this.status = status;
		this.moradorId = moradorId;
	}
	// Getters e Setters para todos os campos
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEspaco() {
		return espaco;
	}
	public void setEspaco(String espaco) {
		this.espaco = espaco;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getMoradorId() {
		return moradorId;
	}
	public void setMoradorId(Long moradorId) {
		this.moradorId = moradorId;
	}
    
   
    
    
}