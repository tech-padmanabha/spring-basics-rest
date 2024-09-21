package io.pn.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.pn.dto.ErrorDetails;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handlerAllException(Exception e,WebRequest req){
		
		return new ResponseEntity<ErrorDetails>(new ErrorDetails(LocalDateTime.now(), req.getDescription(false),Arrays.asList(e.getMessage())),HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(UserNotAvailableException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now()
				, request.getDescription(false),Arrays.asList(ex.getMessage()) );
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
		
	}
	
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
			BindingResult bindingResult = ex.getBindingResult();
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			List<String> errors = new ArrayList<>();
			allErrors.forEach(x -> errors.add(x.getDefaultMessage()));
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), HttpStatus.BAD_REQUEST+"",errors);
		return new ResponseEntity<Object>(ed,HttpStatus.BAD_REQUEST);
	}
	
	
	
}
