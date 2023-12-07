package edu.curso.models;

import java.time.LocalDate;

public class Aviso {
	
	private String tituloAviso;
	private String descricaoAviso;
	private LocalDate dataPublicacao;

	public Aviso() {
		this.dataPublicacao = LocalDate.now();
	}
	
	public LocalDate getDataPublicacao() {
		return this.dataPublicacao;
	}
	
	public String getTituloAviso() {
		return tituloAviso;
	}
	public void setTituloAviso(String tituloAviso) {
		this.tituloAviso = tituloAviso;
	}
	
	public String getDescricaoAviso() {
		return descricaoAviso;
	}
	public void setDescricaoAviso(String descricaoAviso) {
		this.descricaoAviso = descricaoAviso;
	}

}
