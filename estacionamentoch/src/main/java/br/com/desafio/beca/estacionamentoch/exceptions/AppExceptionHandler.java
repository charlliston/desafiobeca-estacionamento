package br.com.desafio.beca.estacionamentoch.exceptions;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javassist.NotFoundException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@EnableAspectJAutoProxy
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
	

	@ExceptionHandler({ NotFoundException.class, Exception.class, NoSuchElementException.class })
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {

		String errorDesc = ex.getLocalizedMessage();
		ExceptionDetails responseMsg = new ExceptionDetails();

		if (errorDesc == null)
			errorDesc = ex.toString();

		responseMsg = new ExceptionDetails(responseMsg.getDataHora(), errorDesc);

		return new ResponseEntity<Object>(responseMsg, HttpStatus.NOT_FOUND);

	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("status", status.value());
		List<String> errors = ex.getBindingResult().getFieldErrors()
				.stream()
				.map(x -> x.getDefaultMessage()).collect(Collectors.toList());
		
		body.put("errors", errors);
		
		return new ResponseEntity<>(body, headers, status);	
	}

}
