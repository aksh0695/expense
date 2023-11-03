package com.backend.expense.Model;

import org.springframework.http.HttpStatus;

public class ResponseModel<T> {
	
	private String responseMessage;
	private HttpStatus httpStatus;
	private String responseStatus;
	private T responseBody;
	
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	public T getResponseBody() {
		return responseBody;
	}
	public void setResponseBody(T responseBody) {
		this.responseBody = responseBody;
	}
	@Override
	public String toString() {
		return "ResponseModel [responseMessage=" + responseMessage + ", httpStatus=" + httpStatus + ", responseStatus="
				+ responseStatus + ", responseBody=" + responseBody + "]";
	}
	
	
	
	
}
