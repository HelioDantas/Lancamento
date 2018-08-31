package br.net.smi.lancamento.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.net.smi.lancamento.model.Categoria;

@Repository
public interface CategoriaRepository extends PagingAndSortingRepository<Categoria, Long>{
	

}
