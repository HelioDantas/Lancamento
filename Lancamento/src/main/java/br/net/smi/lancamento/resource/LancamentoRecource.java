package br.net.smi.lancamento.resource;

import java.time.LocalDate;
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


import br.net.smi.lancamento.model.Lancamento;
import br.net.smi.lancamento.service.LancamentoService;

@RestController
public class LancamentoRecource {
	
	@Autowired
	private LancamentoService lancamentoService;

	
	
	@PostMapping("/Lancamento")
	public ResponseEntity<Lancamento> salvarCategoria(@RequestBody Lancamento lancamento) {
		Lancamento novoLancamento = lancamentoService.salvar(lancamento);
		return new ResponseEntity<Lancamento>(novoLancamento, HttpStatus.OK);

	}

	@GetMapping("/Lancamento")
	public ResponseEntity<List<Lancamento>> buscarCategoria() {
		List<Lancamento> lancamentos = lancamentoService.listar();
		return new ResponseEntity<List<Lancamento>>(lancamentos, HttpStatus.OK);

	}

	@DeleteMapping("/Lancamento/{id}")
	public ResponseEntity<?> detetarCategoria(@PathVariable("id") Long id) {
		lancamentoService.remover(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@PutMapping("/Lancamento")
	public ResponseEntity<Lancamento> atualizarCategoria(@RequestBody Lancamento lancamento) {
		Lancamento novoLancamento = lancamentoService.salvar(lancamento);
		return new ResponseEntity<Lancamento>(novoLancamento, HttpStatus.OK);
	}
	@GetMapping("/Lancamento/buscar/vencimento/{vencimento}")
	public ResponseEntity<List<Lancamento>> buscarPorVencimento(@PathVariable("vencimento") LocalDate vencimento) {
		List<Lancamento> lancamentos = lancamentoService.buscarPorDataVencimento(vencimento);
		return new ResponseEntity<List<Lancamento>>(lancamentos, HttpStatus.OK);

	
}
/*	@GetMapping("/Lancamento/buscar/DataFinal/{data}")
	public ResponseEntity<List<Lancamento>> buscarPorDataFinal(@PathVariable("data") LocalDate data) {
		List<Lancamento> lancamentos = lancamentoService.buscarPorDataFinal(data);
		return new ResponseEntity<List<Lancamento>>(lancamentos, HttpStatus.OK);

	
}
*/

	
}