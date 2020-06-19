package com.devfreitag.orderservice.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.devfreitag.orderservice.domain.exception.RuleException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(RuleException.class)
	public ResponseEntity<Object> handleRUle(RuleException ex, WebRequest request) {
		var status = HttpStatus.BAD_REQUEST;
		
		var responseBody = new ResponseBody();
		responseBody.setStatus(status.value());
		responseBody.setMessage(ex.getMessage());
		responseBody.setDate(LocalDateTime.now());
		
		return handleExceptionInternal(ex, responseBody, new HttpHeaders(), status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		var fields = new ArrayList<ResponseBody.Field>();
		
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String name = ((FieldError) error).getField();
			fields.add(new ResponseBody.Field(name, messageSource.getMessage(error, LocaleContextHolder.getLocale())));
		}
		
		var responseBody = new ResponseBody();
		responseBody.setStatus(status.value());
		responseBody.setMessage("Um ou mais campos estão inválidos.");
		responseBody.setDate(LocalDateTime.now());
		
		responseBody.setFields(fields);
		
		return super.handleExceptionInternal(ex, responseBody, headers, status, request);
	}
}
