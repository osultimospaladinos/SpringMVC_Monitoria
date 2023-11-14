package com.springmonitoria.servicesImpl;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmonitoria.model.Categoria;
import com.springmonitoria.model.Produto;
import com.springmonitoria.repositories.ProdutoRepository;
import com.springmonitoria.services.CategoriaService;
import com.springmonitoria.services.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Override
	public List<Produto> getAllProduto() {
		return produtoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Produto getProdutoById(Long id) {
		return produtoRepository.findById(id).orElse(null);
	}

	@Override
	public Produto saveProduto(Produto produto, Set<Long> categoriaIds) {
		Set<Categoria> categorias = categoriaIds.stream()
				.map(categoriaService::getCategoriaById)
				.filter(Objects::nonNull)
				.collect(Collectors.toSet());
		
		produto.setCategorias(categorias);
		
		return produtoRepository.save(produto);
	}

	@Override
	public Produto updateProduto(Long id, Produto produtoAtualizado) {
		Produto produtoExistente = produtoRepository.findById(id).orElse(null);
		if (produtoExistente != null) { 
			produtoExistente.setNome(produtoAtualizado.getNome());
			produtoExistente.setDescricao(produtoAtualizado.getDescricao());
			produtoExistente.setPreco(produtoAtualizado.getPreco());
			produtoExistente.setImgUrl(produtoAtualizado.getImgUrl());
			
			Set<Categoria> categoriasAtualizadas = produtoAtualizado.getCategorias();
			for ( Categoria categoria : categoriasAtualizadas) { 
				categoria.getProdutos().add(produtoExistente);
			}
			
			produtoExistente.setCategorias(categoriasAtualizadas);
			
			return produtoRepository.save(produtoExistente);
		} else { 
			throw new RuntimeException("Produto com o ID" + id + "não encontrada.");
		}
	}

	@Override
	public void deleteProduto(Long id) {
		produtoRepository.deleteById(id);
	}

}
