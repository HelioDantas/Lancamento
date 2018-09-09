package br.net.smi.lancamento.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.net.smi.lancamento.model.Lancamento;
import br.net.smi.lancamento.model.lancamentoDTO;
import br.net.smi.lancamento.repository.LancamentoRepository;

@Service
public class LancamentoService {
	@Autowired
	private LancamentoRepository lancamentoRepository;
	@Autowired
	private EmpresaService empresaService;
	@Autowired
	private CategoriaService categoriaService;

	public Lancamento salvar(lancamentoDTO lancamentoDTO) {
		Lancamento lancamento = new Lancamento();
		BeanUtils.copyProperties(lancamentoDTO, lancamento);
		lancamento.setEmpresa(empresaService.buscaPorId(lancamentoDTO.getIdEmpresa()));
		lancamento.setCategoria(categoriaService.buscarPorId(lancamentoDTO.getIdCategoria()));
		return lancamentoRepository.save(lancamento);

	}

	public List<Lancamento> listar() {
		return (List<Lancamento>) lancamentoRepository.findAll();

	}

	public Lancamento atualizar(Lancamento lancamento) {
		return lancamentoRepository.save(lancamento);

	}

	public void remover(Long id) {
		lancamentoRepository.deleteById(id);

	} 

	public List<Lancamento> buscarPorDataVencimento(LocalDate vencimentoInical,LocalDate vencimentoFinal) {

		return lancamentoRepository.findByVencimentoBetween(vencimentoInical, vencimentoFinal);
	}


	
	


}
