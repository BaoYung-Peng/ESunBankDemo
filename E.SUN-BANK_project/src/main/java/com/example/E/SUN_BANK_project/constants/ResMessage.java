package com.example.E.SUN_BANK_project.constants;

public enum ResMessage {
	SUCCESS(200, "Success!"), //
	SEAT_NOT_FOUND(404, "Seat does not exist"), //
	SEAT_OCCUPIED(409, "Seat is already occupied"), //
	EMPLOYEE_NOT_FOUND(404, "Employee not found"), //
	;

	private int code;

	private String message;

	ResMessage(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
