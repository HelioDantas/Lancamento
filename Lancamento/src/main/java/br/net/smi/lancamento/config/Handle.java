package br.net.smi.lancamento.config;

import java.time.LocalDate;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.net.smi.lancamento.model.Erro;

@ControllerAdvice
public class Handle extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = { ResourceNotFoundException.class })
	public ResponseEntity<Object> notFound(ResourceNotFoundException rn, WebRequest request) {

		Erro novoErro = new Erro();
		novoErro.setDetail(rn.getMessage());
		novoErro.setDevMensagem(rn.getClass().getName());
		novoErro.setStatus(HttpStatus.NOT_FOUND.value());
		novoErro.setTimeStamp(LocalDate.now());
		novoErro.setTitle(PAGE_NOT_FOUND_LOG_CATEGORY);
		return handleExceptionInternal(rn,novoErro, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	
	}



}
