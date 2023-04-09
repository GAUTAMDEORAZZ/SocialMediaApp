package com.masai.Service;



import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.ExceptionHandler.PostException;
import com.masai.ExceptionHandler.UserException;
import com.masai.Model.Post;
import com.masai.Model.User;
import com.masai.Repository.PostDao;
import com.masai.Repository.UserDao;

@Service
public class PostServiceImpl implements PostService {
    
	@Autowired
	private PostDao postDao;
	
	
	@Autowired
	private UserDao userDao;
	
	
	
	@Override
	public Post createPost(Post post,Integer id) throws UserException {
		Optional<User> opt= userDao.findById(id);
		
		if(opt.isPresent()) {
			User existingUser=opt.get();
//			existingUser.getPosts().add(post);
		    post.setUser(existingUser);
			post.setCreated_at(LocalDateTime.now());
		    return postDao.save(post);
			
		}
		
		else {
			throw new UserException("There is no user found of this UserId --- "+id );
		}
		
	}

	@Override
	public Post getPostByid(Integer id) throws PostException {
		Optional<Post> opt=postDao.findById(id);
		
		return opt.orElseThrow(() -> new PostException("There is no post found of this id"));
	}

	@Override
	public Post updatePostContent(Integer id,String Content) throws PostException {
		Optional<Post> opt=postDao.findById(id);
		if(opt.isPresent()) {
			Post existPost=opt.get();
			existPost.setContent(Content);
			existPost.setUpdated_at(LocalDateTime.now());
		  return postDao.save(existPost);
			
		}
		else {
			throw new PostException("There is no post found of this id"+id);
		}
	}

	@Override
	public Post deleteByid(Integer id) throws PostException {
		Optional<Post> opt=postDao.findById(id);
		if(opt.isPresent()) {
			Post existPost=opt.get();
			 postDao.deleteById(id);
			 return existPost;
			
		}
		else {
			throw new PostException("No Post Found of this id");
		}
	}

	@Override
	public String LikeIncrement(Integer id) throws PostException {
		Optional<Post> opt=postDao.findById(id);
		if(opt.isPresent()) {
			Post existPost=opt.get();
			existPost.setLikes(existPost.getLikes()+1);
			postDao.save(existPost);
			return "The like of post is"+existPost.getLikes();
		}
		else {
			throw new PostException("No Post Found of this id");
		}
	}

	@Override
	public String LikeDecrement(Integer id) throws PostException {
		Optional<Post> opt=postDao.findById(id);
		if(opt.isPresent()) {
			Post existPost=opt.get();
			existPost.setLikes(existPost.getLikes()-1);
			postDao.save(existPost);
			return "The like of post is"+existPost.getLikes();
		}
		else {
			throw new PostException("No Post Found of this id");
		}
	}

}
