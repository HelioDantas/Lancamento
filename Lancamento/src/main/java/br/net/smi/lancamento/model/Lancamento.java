
package br.net.smi.lancamento.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;


@Getter@Setter
@Entity
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String tipo;
	private LocalDate vencimento;
	private LocalDate dataDeInicio;
	private LocalDate dataDeFinal;
	private  BigDecimal valor;
	 @ManyToOne
	 @JoinColumn(name="empresa_id")
	 private Empresa empresa;
	
	 @ManyToOne
	 @JoinColumn(name="categoria_id")
	 private Categoria categoria;

}

