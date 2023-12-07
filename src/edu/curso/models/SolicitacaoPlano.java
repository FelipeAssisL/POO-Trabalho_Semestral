package edu.curso.models;

public class SolicitacaoPlano {
	
	private String idSolicitacao;
	private Aluno aluno;
	private Plano plano;
	
	
	public String getIdSolicitacao() {
		return idSolicitacao;
	}

	public void setIdSolicitacao(String idSolicitacao) {
		this.idSolicitacao = idSolicitacao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}
}
