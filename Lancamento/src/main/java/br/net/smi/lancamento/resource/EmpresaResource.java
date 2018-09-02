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

import br.net.smi.lancamento.model.Empresa;
import br.net.smi.lancamento.service.EmpresaService;

@RestController
public class EmpresaResource {

	@Autowired
	private EmpresaService empresaService;

	@PostMapping("/Empresa")
	public ResponseEntity<Empresa> salvarEmpresa(@RequestBody Empresa empresa) {
		Empresa novaEmpresa = empresaService.salvar(empresa);
		return new ResponseEntity<>(novaEmpresa, HttpStatus.OK);
	}

	@GetMapping("/Empresa")
	public ResponseEntity<List<Empresa>> buscarEmpresas() {
		List<Empresa> Empresas = empresaService.listar();
		return new ResponseEntity<List<Empresa>>(Empresas, HttpStatus.OK);

	}

	@DeleteMapping("/Empresa/{id}")
	public ResponseEntity<?> detetarEmpresa(@PathVariable("id") Long id){
		empresaService.remover(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	@PutMapping("/Empresa")
	public ResponseEntity<Empresa> atualizarEmpresa(@RequestBody Empresa empresa){
		Empresa empresaAtualizada = empresaService.salvar(empresa);
		return new ResponseEntity<Empresa>(empresaAtualizada, HttpStatus.OK);
			
	}
	

/*	@GetMapping("/Empresa/buscarEmpresa/nomeOuNnpj/{nome}")
	public ResponseEntity<List<Empresa>> buscarEmpresaPorNome(@PathVariable("nome") String nome) {
		List<Empresa> empresas = empresaService.buscarPorNomeOuCnpj(nome);
		return new ResponseEntity<>(empresas, HttpStatus.OK);
	}*/


}