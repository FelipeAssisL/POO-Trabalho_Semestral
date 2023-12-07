package edu.curso.dao;

import java.util.List;

import edu.curso.models.Tutor;

public interface InterfTutorDAO {
	public void salvar(Tutor tutor);
	public List<Tutor> lerTodos();
	public List<Tutor> pesquisarPorNome(String nome);
}
