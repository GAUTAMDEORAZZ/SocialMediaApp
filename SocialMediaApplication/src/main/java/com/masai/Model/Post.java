package com.masai.Model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Post {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
    

	
	@Size(min=1, max=300, message="The content size should be not less than 1 and greater than 300")
	private String content;
	
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
	
	private Integer likes;
	
	
     
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="UserId")
	private User user;
	
}
