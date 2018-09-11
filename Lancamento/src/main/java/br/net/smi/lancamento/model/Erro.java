package br.net.smi.lancamento.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Erro {

	private String title;
	private int status;
	private String detail;
	private LocalDate timeStamp;
	private String DevMensagem;
}
