package br.com.cliente.api.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor
public class ErrorDetail {
	
	private String title;
	private int status;
	private String messageDetail;
	private LocalDate data;
	private String message;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("{ ").append("\n");
		sb.append("\"title\":").append("\""+title).append("\",\n");
		sb.append("\"status\":").append("\""+status).append("\",\n");
		sb.append("\"messageDetail\":").append(messageDetail).append(",\n");
		sb.append("\"data\":").append("\""+data).append("\",\n");
		sb.append("\"message\":").append("\""+message).append("\"\n");
		sb.append(" } ");

		return sb.toString();
	}
}
