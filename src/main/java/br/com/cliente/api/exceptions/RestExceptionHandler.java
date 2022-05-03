package br.com.cliente.api.exceptions;

import lombok.SneakyThrows;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {   

	
	@ExceptionHandler(GenericException.class)
    public ResponseEntity<ErrorDetail> handleValidaCamposException(GenericException vld, HttpServletRequest request) {
		
		ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setData( LocalDate.now());
        errorDetail.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorDetail.setTitle("Erro na Operação");
        errorDetail.setMessageDetail(vld.getCustomMessage());
        errorDetail.setMessage(ServiceExceptionHandlerEnum.ERRO500.getDescription());

        return new ResponseEntity<ErrorDetail>(errorDetail, null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetail> geralException(Exception exc, HttpServletRequest request) {

		ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setData( LocalDate.now());
        errorDetail.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorDetail.setTitle("Erro Interno");
        errorDetail.setMessageDetail(exc.getMessage());
        errorDetail.setMessage(ServiceExceptionHandlerEnum.ERRO500.getDescription());

        return new ResponseEntity<ErrorDetail>(errorDetail, null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	
	@ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDetail> erroInternoException(NullPointerException exc, HttpServletRequest request) {
		
		ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTitle("API - Clientes");
        errorDetail.setData( LocalDate.now());
        errorDetail.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorDetail.setMessage(ServiceExceptionHandlerEnum.ERRO500.getDescription());
        errorDetail.setMessageDetail(exc.getMessage());

        return new ResponseEntity<ErrorDetail>(errorDetail, null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<ErrorDetail> erroDadosInvalidos(InvalidDataException exc, HttpServletRequest request) {

        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTitle("API - Clientes");
        errorDetail.setData( LocalDate.now());
        errorDetail.setStatus(HttpStatus.CONFLICT.value());
        errorDetail.setMessage(ServiceExceptionHandlerEnum.ERRO409.getDescription());
        errorDetail.setMessageDetail(exc.getCustomMessage());

        return new ResponseEntity<ErrorDetail>(errorDetail, null, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(RequiredDataException.class)
    public ResponseEntity<ErrorDetail> erroDadosObrigatorios(RequiredDataException exc, HttpServletRequest request) {

        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTitle("API - Clientes");
        errorDetail.setData( LocalDate.now());
        errorDetail.setStatus(HttpStatus.CONFLICT.value());
        errorDetail.setMessage(ServiceExceptionHandlerEnum.ERRO409B.getDescription());
        errorDetail.setMessageDetail(exc.getCustomMessage());

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errorDetail);
    }
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ErrorDetail> erroDadoNaoEncontrado(EmptyResultDataAccessException exc, HttpServletRequest request) {

        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTitle("API - Clientes");
        errorDetail.setData( LocalDate.now());
        errorDetail.setStatus(HttpStatus.NO_CONTENT.value());
        errorDetail.setMessage(ServiceExceptionHandlerEnum.EXCP204.getDescription());
        errorDetail.setMessageDetail(exc.getMessage());

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(errorDetail);
    }

    @ExceptionHandler(NotFoundDataException.class)
    public ResponseEntity<ErrorDetail> erroDadoNaoEncontrado(NotFoundDataException exc, HttpServletRequest request) {

        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTitle("API - Clientes");
        errorDetail.setData( LocalDate.now());
        errorDetail.setStatus(HttpStatus.NO_CONTENT.value());
        errorDetail.setMessage(ServiceExceptionHandlerEnum.EXCP204.getDescription());
        errorDetail.setMessageDetail(exc.getCustomMessage());

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(errorDetail);

    }

    @SneakyThrows
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exc,
                                                                          HttpHeaders headers, HttpStatus status,
                                                                          WebRequest request) {
        StringBuilder message = new StringBuilder();
        message.append("[");
        exc.getBindingResult().getFieldErrors().forEach( mens -> {
            message.append("{");
            message.append( "\"Campo\":").append("\""+mens.getField()).append("\" ,");
            message.append("\"Mensagem\":").append("\""+ mens.getDefaultMessage()).append("\"");
            message.append("},");

        });
        message.replace(message.length() - 1, message.length(), "");
        message.append("]");

        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTitle("API - Clientes");
        errorDetail.setData( LocalDate.now());
        errorDetail.setStatus(HttpStatus.NO_CONTENT.value());
        errorDetail.setMessage(ServiceExceptionHandlerEnum.ERRO409.getDescription());
        errorDetail.setMessageDetail(message.toString());

        return response(exc, request, HttpStatus.CONFLICT, errorDetail.toString(), headers);

    }

    private ResponseEntity<Object> response(Exception ex, WebRequest request, HttpStatus status,
                                            String message, HttpHeaders headers) {
        return handleExceptionInternal(ex, message, headers, status, request);
    }

}
