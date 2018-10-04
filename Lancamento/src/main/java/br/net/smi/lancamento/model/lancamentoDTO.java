package br.net.smi.lancamento.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter


public class lancamentoDTO {

	private Long id;
	private String tipo;
	@NotNull
	private LocalDate vencimento;
	@NotNull
	private BigDecimal valor;
	@NotNull
	private Long idEmpresa;
	@NotNull
	private Long idCategoria;
	
}
