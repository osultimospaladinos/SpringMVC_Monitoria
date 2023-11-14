package com.springmonitoria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmonitoria.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
