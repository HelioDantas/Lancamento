package br.net.smi.lancamento.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.net.smi.lancamento.model.Lancamento;
import br.net.smi.lancamento.repository.LancamentoRepository;

@Service
public class LancamentoService {
	@Autowired
	private LancamentoRepository lancamentoRepository;

	public Lancamento salvar(Lancamento lancamento) {
		return lancamentoRepository.save(lancamento);

	}

	public List<Lancamento> listar() {
		return (List<Lancamento>) lancamentoRepository.findAll();

	}

	public Lancamento atualizar(Lancamento empresa) {
		return lancamentoRepository.save(empresa);

	}

	public void remover(Long id) {
		lancamentoRepository.deleteById(id);

	}

	public List<Lancamento> buscarPorDataInicial(LocalDate data) {

		return lancamentoRepository.findByDataDeInicio(data);
	}

	public List<Lancamento> buscarPorDataFinal(LocalDate data) {

		return lancamentoRepository.findByDataDeFinal(data);
	}

}
