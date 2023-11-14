package com.springmonitoria.services;

import java.util.List;

import com.springmonitoria.model.Categoria;

public interface CategoriaService {

	List<Categoria> getAllCategorias();
	
	Categoria getCategoriaById(Long id);
	
	Categoria saveCategoria(Categoria categoria);
	
	Categoria updateCategoria(Long id, Categoria categoriaAtualizada);
	
	void deleteCategoria(Long id);
}
