package edu.curso.models;

import java.time.LocalDate;

public class Aula {
	
	private int id;
	private String nomeAula;
	private String descricaoAula;
	private String horaAula;
	private Instrutor instrutor;
	private LocalDate dataAula;

	public Instrutor getInstrutor() {
		return instrutor;
	}
	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNomeAula() {
		return nomeAula;
	}
	
	public void setNomeAula(String nomeAula) {
		this.nomeAula = nomeAula;
	}
	
	public String getDescricaoAula() {
		return descricaoAula;
	}
	
	public void setDescricaoAula(String descricaoAula) {
		this.descricaoAula = descricaoAula;
	}
	
	public String getHoraAula() {
		return horaAula;
	}
	
	public void setHoraAula(String horaAula) {
		this.horaAula = horaAula;
	}
	
	public LocalDate getDataAula() {
		return dataAula;
	}
	
	public void setDataAula(LocalDate dataAula) {
		this.dataAula = dataAula;
	}
	
}
