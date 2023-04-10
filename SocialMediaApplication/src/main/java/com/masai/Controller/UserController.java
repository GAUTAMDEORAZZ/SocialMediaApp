package com.masai.Controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.ExceptionHandler.UserException;
import com.masai.Model.User;
import com.masai.Service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins= "*",allowedHeader = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<User> createUserHandler(@Valid @RequestBody User user){
		
		User saveUser=userService.createNewUser(user);
		
		return new ResponseEntity<User>(saveUser,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserHandler(@PathVariable("id") Integer id)throws UserException{
		User getUser=userService.getUserDetailsById(id);
		return new ResponseEntity<User>(getUser,HttpStatus.FOUND);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUserHandler(@Valid  @PathVariable("id") Integer id, @RequestParam("name") String name, @RequestParam("bio") String bio)throws UserException{
		
		
		User updateUser=userService.updateUserDetails(id, name, bio);
		return new ResponseEntity<User>(updateUser,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUserHandler(@PathVariable("id") Integer id)throws UserException{
		String deleteUser=userService.deleteByid(id);
		return new ResponseEntity<String>(deleteUser,HttpStatus.OK);
	}
	
	@GetMapping("/analytics/users")
	public ResponseEntity<List<User>> getAllRecordHandler()throws UserException{
		List<User> userList=userService.getAllUserDetails();
		return new ResponseEntity<List<User>>(userList,HttpStatus.FOUND);	
		}
	

}
