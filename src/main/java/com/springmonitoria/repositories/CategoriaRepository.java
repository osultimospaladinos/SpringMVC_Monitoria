package com.springmonitoria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmonitoria.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
}
