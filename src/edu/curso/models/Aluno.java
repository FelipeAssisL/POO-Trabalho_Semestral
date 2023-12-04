package edu.curso.models;

import java.time.LocalDate;

public class Aluno {
	
	
	private int idAluno;
	private String nomeAluno;
	private String rgAluno;
	private LocalDate dtNascAluno;
	private LocalDate dtEntrada;
	private String emailAluno;
	private String foneAluno;
	private Plano planoContratado;
	

	public int getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public String getRgAluno() {
		return rgAluno;
	}
	public void setRgAluno(String rgAluno) {
		this.rgAluno = rgAluno;
	}
	public LocalDate getdtNascAluno() {
		return dtNascAluno;
	}
	public void setDtNascimento(LocalDate dtNascAluno) {
		this.dtNascAluno = dtNascAluno;
	}
	public LocalDate getDtEntrada() {
		return dtEntrada;
	}
	public void setDtEntrada(LocalDate dtEntrada) {
		this.dtEntrada = dtEntrada;
	}
	public String getEmailAluno() {
		return emailAluno;
	}
	public void setEmailAluno(String emailAluno) {
		this.emailAluno = emailAluno;
	}
	public String getFoneAluno() {
		return foneAluno;
	}
	public void setFoneAluno(String foneAluno) {
		this.foneAluno = foneAluno;
	}
	public Plano getPlanoContratado() {
		return planoContratado;
	}
	public void setPlanoContratado(Plano planoContratado) {
		this.planoContratado = planoContratado;
	}
}
