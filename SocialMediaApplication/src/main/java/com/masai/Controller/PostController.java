package com.masai.Controller;

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

import com.masai.ExceptionHandler.PostException;
import com.masai.ExceptionHandler.UserException;
import com.masai.Model.Post;
import com.masai.Service.PostService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "https://socialmediaapp-production-7995.up.railway.app/")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/posts/{userId}")
	public ResponseEntity<Post> createPostHandler(@Valid @RequestBody Post post,@PathVariable("userId") Integer userId)throws UserException{
		post.setLikes(0);
		Post savePost=postService.createPost(post, userId);
		
		return new ResponseEntity<Post>(savePost,HttpStatus.CREATED);
	}
	
	@GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostDetailsHandler(@PathVariable("id") Integer id)throws PostException{
		
		Post getPost=postService.getPostByid(id);
		
		return new ResponseEntity<Post>(getPost,HttpStatus.CREATED);
	}
	
	@PutMapping("/posts/{postId}")
    public ResponseEntity<Post> updatePostHandler( @PathVariable("postId") Integer postId,@RequestParam("Content") String content)throws PostException{
		
		Post updatePost=postService.updatePostContent(postId, content);
		
		return new ResponseEntity<Post>(updatePost,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/posts/{id}")
    public ResponseEntity<Post> deletePostHandler(@PathVariable("id") Integer postId)throws PostException{
		
		Post updatePost=postService.deleteByid(postId);
		
		return new ResponseEntity<Post>(updatePost,HttpStatus.CREATED);
	}
	
	@PostMapping("/posts/{Id}/like")
	public ResponseEntity<String> likePostHandler(@RequestBody @PathVariable("Id") Integer Id)throws PostException{
		
		String likePost=postService.LikeIncrement(Id);
		
		return new ResponseEntity<String>(likePost,HttpStatus.CREATED);
	}
	
	@PostMapping("/posts/{Id}/unLike")
	public ResponseEntity<String> dislikePostHandler(@RequestBody @PathVariable("Id") Integer Id)throws PostException{
		
		String unLikePost=postService.LikeDecrement(Id);
		
		return new ResponseEntity<String>(unLikePost,HttpStatus.CREATED);
	}
	
}


