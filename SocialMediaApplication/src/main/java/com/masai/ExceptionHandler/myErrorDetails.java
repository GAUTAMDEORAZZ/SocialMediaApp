package com.masai.ExceptionHandler;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class myErrorDetails {
	
	private String message;
	private LocalDateTime timeStamp;
	private String details;
	
	

}
