package br.net.smi.lancamento.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import br.net.smi.lancamento.model.Categoria;

import br.net.smi.lancamento.service.CategoriaService;

@RestController
public class CategoriaResource {
	@Autowired
	private CategoriaService categoriaService;

	@PostMapping("/Categoria")
	public ResponseEntity<Categoria> salvarCategoria(@RequestBody Categoria categoria) {
		Categoria novaCategoria = categoriaService.salvar(categoria);
		return new ResponseEntity<Categoria>(novaCategoria, HttpStatus.OK);

	}

	@GetMapping("/Categoria")
	public ResponseEntity<List<Categoria>> buscarCategoria() {
		List<Categoria> categorias = categoriaService.listar();
		return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.OK);

	}

	@DeleteMapping("/Categoria/{id}")
	public ResponseEntity<?> detetarCategoria(@PathVariable("id") Long id) {
		categoriaService.remover(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@PutMapping("/Categoria")
	public ResponseEntity<Categoria> atualizarCategoria(@RequestBody Categoria categoria) {
		Categoria novaCategoria = categoriaService.salvar(categoria);
		return new ResponseEntity<Categoria>(novaCategoria, HttpStatus.OK);
	}
}
