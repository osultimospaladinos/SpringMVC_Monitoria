package com.springmonitoria.services;

import java.util.List;
import java.util.Set;

import com.springmonitoria.model.Produto;

public interface ProdutoService {

	List<Produto> getAllProduto();
	
	Produto getProdutoById(Long id);
	
	Produto saveProduto(Produto produto, Set<Long> categoriaIds);
	
	Produto updateProduto(Long id, Produto produtoAtualizado);
	
	void deleteProduto(Long id);
}
