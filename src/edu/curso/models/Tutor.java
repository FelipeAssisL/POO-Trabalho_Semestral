package edu.curso.models;

public class Tutor {
	private int idTutor;
	private String nomeTutor;
	private String especialidadeTutor;
	private String descricaoTutor;
	
	public int getIdTutor() {
		return idTutor;
	}
	public void setIdTutor(int idTutor) {
		this.idTutor = idTutor;
	}
	public String getNomeTutor() {
		return nomeTutor;
	}
	public void setNomeTutor(String nomeTutor) {
		this.nomeTutor = nomeTutor;
	}
	public String getEspecialidadeTutor() {
		return especialidadeTutor;
	}
	public void setEspecialidadeTutor(String especialidadeTutor) {
		this.especialidadeTutor = especialidadeTutor;
	}
	public String getDescricaoTutor() {
		return this.descricaoTutor;
	}
	public void setDescricaoTutor(String descricaoTutor) {
		this.descricaoTutor = descricaoTutor;
	}
	
}
