package edu.curso.dao;

import java.util.List;
import edu.curso.models.Equipamento;

public interface InterfEquipamentoDAO {
	
	public void salvar(Equipamento equip);
	public List<Equipamento> lerTodos();
	public List<Equipamento> pesquisarPorNome(String tituloEquip);

}
