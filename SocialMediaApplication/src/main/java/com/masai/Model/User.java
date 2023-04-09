package com.masai.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
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
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Size(min=1, max=50, message="character should be 1-50 character")
	private String name;
	
	@Email(message= "Your email is not in proper formate")
	private String email;
	
	
	private String bio;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
	
//	@JsonIgnore
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
//	List<Post> posts=new ArrayList<>();

}
