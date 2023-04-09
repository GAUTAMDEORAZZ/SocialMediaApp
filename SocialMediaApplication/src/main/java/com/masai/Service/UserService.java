package com.masai.Service;

import java.util.List;

import com.masai.ExceptionHandler.UserException;
import com.masai.Model.User;

public interface UserService {
	public User createNewUser(User user);
	public User getUserDetailsById(Integer id) throws  UserException;
	public User updateUserDetails(Integer id,String name, String bio)throws UserException;
	public String deleteByid(Integer id)throws UserException;
	public List<User> getAllUserDetails()throws UserException;
//	public List<User> topFiveActiveuser()throws UserException;
	
	



}
