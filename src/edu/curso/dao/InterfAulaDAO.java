package edu.curso.dao;

import java.util.List;

import edu.curso.models.Aula;

public interface InterfAulaDAO {
	public void salvar(Aula aula);
	public List<Aula> lerTodos();
	public List<Aula> pesquisarPorNome(String titulo);

}
