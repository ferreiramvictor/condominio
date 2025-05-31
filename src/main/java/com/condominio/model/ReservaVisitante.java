package com.condominio.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ReservaVisitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "vaga_id")
    private VagaVisitante vaga;
    
    @ManyToOne
    @JoinColumn(name = "morador_id")
    private Morador morador;
    
    private LocalDateTime dataReserva;
    private String nomeVisitante;
    private String documentoVisitante;
    private String status; // "CONFIRMADA", "CANCELADA", "UTILIZADA"
    
    
	public ReservaVisitante(Long id, VagaVisitante vaga, Morador morador, LocalDateTime dataReserva,
			String nomeVisitante, String documentoVisitante, String status) {
		this.id = id;
		this.vaga = vaga;
		this.morador = morador;
		this.dataReserva = dataReserva;
		this.nomeVisitante = nomeVisitante;
		this.documentoVisitante = documentoVisitante;
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public VagaVisitante getVaga() {
		return vaga;
	}
	public void setVaga(VagaVisitante vaga) {
		this.vaga = vaga;
	}
	public Morador getMorador() {
		return morador;
	}
	public void setMorador(Morador morador) {
		this.morador = morador;
	}
	public LocalDateTime getDataReserva() {
		return dataReserva;
	}
	public void setDataReserva(LocalDateTime dataReserva) {
		this.dataReserva = dataReserva;
	}
	public String getNomeVisitante() {
		return nomeVisitante;
	}
	public void setNomeVisitante(String nomeVisitante) {
		this.nomeVisitante = nomeVisitante;
	}
	public String getDocumentoVisitante() {
		return documentoVisitante;
	}
	public void setDocumentoVisitante(String documentoVisitante) {
		this.documentoVisitante = documentoVisitante;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
}