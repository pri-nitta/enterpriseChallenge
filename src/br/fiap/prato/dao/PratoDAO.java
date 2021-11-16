package br.fiap.prato.dao;

import java.util.List;

import br.fiap.prato.entity.Prato;

public interface PratoDAO {
	
	void gravar (Prato prato);
	
	List<Prato> buscarTodos();
	
	Prato buscarTodosPorCodigo(int codigo);
	
	void atualizar (Prato prato);
	
	void remover (int codigo);
}
