package com.bankmanagmentsystem.www.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<CustomeErrorResponse> handleNotFoundException(NotFoundException e){
		CustomeErrorResponse customeErrorResponse = new CustomeErrorResponse("NOT_FOUND_EXCEPTION", e.getMessage());
		customeErrorResponse.setStatus(HttpStatus.NOT_FOUND.toString());
		customeErrorResponse.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<>(customeErrorResponse, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(CustomerOverwriteException.class)
	public ResponseEntity<CustomeErrorResponse> handleCustomeOverwriteException(CustomerOverwriteException e){
		CustomeErrorResponse customeErrorResponse = new CustomeErrorResponse("CUSTOMER_OVER_WRITE_EXCEPTION", e.getMessage());
		customeErrorResponse.setStatus(HttpStatus.CONFLICT.toString());
		customeErrorResponse.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<>(customeErrorResponse, HttpStatus.CONFLICT);
		
	}
	@ExceptionHandler(InsufficientfundException.class)
	public ResponseEntity<CustomeErrorResponse> handleInsufficientFundException(InsufficientfundException e){
		CustomeErrorResponse customeErrorResponse = new CustomeErrorResponse("INSUFFICIRNT_FUNDS_EXCEPTION", e.getMessage());
		customeErrorResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
		customeErrorResponse.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<>(customeErrorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IdenticalAccountException.class)
	public ResponseEntity<CustomeErrorResponse> handleIdenticalAccountException(IdenticalAccountException e){
		CustomeErrorResponse customeErrorResponse = new CustomeErrorResponse("IDENTICAL_ACCOUNT_EXCEPTION", e.getMessage());
		customeErrorResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
		customeErrorResponse.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<>(customeErrorResponse, HttpStatus.BAD_REQUEST);
	}

}
