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
//	public List<Empresa> buscarPorNomeOuCnpj(String nome) {
	//	return empresaRepository.findByNomeOrCnpjIgnoreCaseContainig(nome);
		
	//}
	

	public Empresa buscaPorId(Long id){
		return empresaRepository.findById(id).get();
		
		
	}

}
