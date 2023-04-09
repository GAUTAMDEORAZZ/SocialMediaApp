package com.masai.Service;

import com.masai.ExceptionHandler.PostException;
import com.masai.ExceptionHandler.UserException;
import com.masai.Model.Post;

public interface PostService {
	
	public Post createPost(Post post,Integer id)throws UserException;
	public Post getPostByid(Integer id)throws PostException;
	public Post updatePostContent(Integer id,String content)throws PostException;
	public Post deleteByid(Integer id)throws PostException;
	public String LikeIncrement(Integer id)throws PostException;
	public String LikeDecrement(Integer id)throws PostException;
	
	

}
