package br.net.smi.lancamento.model;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;

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
	@CNPJ
	private String cnpj;
	@NotNull
	private String nomeResponsavel;
	
	
	
	
	
	

}
