package com.masai.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.ExceptionHandler.UserException;
import com.masai.Model.Post;
import com.masai.Model.User;
import com.masai.Repository.PostDao;
import com.masai.Repository.UserDao;

import ch.qos.logback.core.joran.conditional.ThenOrElseActionBase;

@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	private UserDao dao;
	
	@Autowired
	private PostDao postdao;
	
	@Override
	public User createNewUser(User user) {
		
		
		 user.setCreated_at(LocalDateTime.now());
		
		 User saveUser=dao.save(user);
		 return saveUser;
	}

	@Override
	public User getUserDetailsById(Integer id) throws UserException {
		
	Optional<User> opt=dao.findById(id);
	  return opt.orElseThrow(() -> new UserException("There is no user found of this id" +id ));
	}

	@Override
	public User updateUserDetails(Integer id,String name,String bio) throws UserException {
		Optional<User> opt=dao.findById(id);
		if(opt.isPresent()) {
			User existingUser=opt.get();
			existingUser.setUpdated_at(LocalDateTime.now());
			existingUser.setName(name);
			existingUser.setBio(bio);
			return existingUser;
		}
		else {
			throw new UserException("There is no user exist with this id" +id);
		}
		
	}

	@Override
	public String deleteByid(Integer id) throws UserException {
		Optional<User> opt=dao.findById(id);
		if(opt.isPresent()) {
			User existingUser=opt.get();
			dao.delete(existingUser);
			
			return "The user of this id" +id + "is deleted Successfully";
		}
		
		else {
			throw new UserException("There is no user exist with this id" +id);
		}
	}

	@Override
	public List<User> getAllUserDetails() throws UserException {
		 List<User> userList=dao.findAll();	
		 if(userList.size()>0) {
			 return userList;
		 }
		 
		 throw new UserException("There is no data Found");
	}
		

//	@Override
//	public List<User> topFiveActiveuser() throws UserException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
