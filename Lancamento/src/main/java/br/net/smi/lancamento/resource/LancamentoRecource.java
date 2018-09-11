package br.net.smi.lancamento.resource;

import java.time.LocalDate;
//import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.net.smi.lancamento.model.Lancamento;
import br.net.smi.lancamento.model.lancamentoDTO;
import br.net.smi.lancamento.service.LancamentoService;

@RestController
public class LancamentoRecource {

	@Autowired
	private LancamentoService lancamentoService;

	@PostMapping("/Lancamento")
	public ResponseEntity<Lancamento> salvarCategoria(@RequestBody @Valid lancamentoDTO lancamentoDto) {
		Lancamento novoLancamento = lancamentoService.salvar(lancamentoDto);
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
	public ResponseEntity<Lancamento> atualizarCategoria(@RequestBody @Valid lancamentoDTO lancamentoDto) {
		Lancamento novoLancamento = lancamentoService.atualizar(lancamentoDto);
		return new ResponseEntity<Lancamento>(novoLancamento, HttpStatus.OK);
	}

	@GetMapping("/Lancamento/buscar/")
	public ResponseEntity<List<Lancamento>> buscarPorVencimento(@RequestParam("vencimentoInicial") @DateTimeFormat(pattern="dd-mm-yyyy")LocalDate dataDeInicio,
	@RequestParam("vencimentoFinal") @DateTimeFormat(pattern="dd-mm-yyyy")LocalDate vencimentoI){
		List<Lancamento> lancamentos = lancamentoService.buscarPorDataVencimento(dataDeInicio,vencimentoI );
		return new ResponseEntity<List<Lancamento>>(lancamentos, HttpStatus.OK);

	
}


	
}