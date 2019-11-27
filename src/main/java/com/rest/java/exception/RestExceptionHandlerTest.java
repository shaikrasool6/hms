
package com.rest.java.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class RestExceptionHandlerTest extends ResponseEntityExceptionHandler {
/*

	Hospital hospital;
	@ExceptionHandler(RestExcpetion.class)
	public ResponseEntity<ErrorResponse> exceptionToHandler(Exception ex) {

		ErrorResponse error = new ErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());

		error.setMessage(ex.getMessage());

		System.out.println("from error messgae ");

		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage("internal server error");
	
	 		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}

*/
	@ExceptionHandler(HospitalCustomException.class)
	public void springHandleNotFound(HttpServletResponse response) throws Exception {
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}
	
	
	@ExceptionHandler(Exception.class)
	public void springInternalServer(HttpServletResponse response)throws Exception {
		response.sendError(HttpStatus.NOT_FOUND.value(),"make sure Id not exist");
	}



}
