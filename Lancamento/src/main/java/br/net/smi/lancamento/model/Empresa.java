package br.net.smi.lancamento.model;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
@Entity
public class Empresa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String nome;
	@Column(length=14)
	private String cnpj;
	private String nomeResponsavel;
	
	
	
	
	
	

}
