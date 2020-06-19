package com.devfreitag.orderservice.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

public class ResponseBody {

	private Integer status;
	private LocalDateTime date;
	private String message;
	private List<Field> fields;
	
	public static class Field {
		
		private String name;
		private String error;			
		
		public Field(String name, String error) {
			super();
			this.name = name;
			this.error = error;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getError() {
			return error;
		}
		public void setError(String error) {
			this.error = error;
		}
				
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}		
	
}
