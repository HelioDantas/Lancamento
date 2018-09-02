package br.net.smi.lancamento.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter


public class lancamentoDTO {

	private Long id;
	private String tipo;
	private LocalDate vencimento;

	private BigDecimal valor;

	private Long idEmpresa;

	private Long idCategoria;
	
}
