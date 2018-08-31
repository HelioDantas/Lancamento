package br.net.smi.lancamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.net.smi.lancamento.model.Categoria;
import br.net.smi.lancamento.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaReposirory;

	public Categoria salvar(Categoria categoria) {
		return categoriaReposirory.save(categoria);

	}

	public List<Categoria> listar() {
		return (List<Categoria>) categoriaReposirory.findAll();

	}

	public Categoria atualizar(Categoria categoria) {
		return categoriaReposirory.save(categoria);

	}

	public void remover(Long id) {
		categoriaReposirory.deleteById(id);

	}

}
