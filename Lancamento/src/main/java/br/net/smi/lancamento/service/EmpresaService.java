package br.net.smi.lancamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import br.net.smi.lancamento.model.Empresa;
import br.net.smi.lancamento.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	public Empresa salvar(Empresa empresa) {
		return empresaRepository.save(empresa);

	}

	public List<Empresa> listar() {
		return (List<Empresa>) empresaRepository.findAll();

	}

	public Empresa atualizar(Empresa empresa) {
		return empresaRepository.save(empresa);

	}
	
	public void remover(Long id) {
		empresaRepository.deleteById(id);
	
		
	}
	public Empresa buscarPorNome(String nome) {
		return empresaRepository.findByNome(nome);
		
	}
	
	public Empresa buscarPorCnpj(String cnpj) {
		return empresaRepository.findByCnpj(cnpj);
		
	}
	

}
