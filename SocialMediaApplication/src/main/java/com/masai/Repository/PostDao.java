package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.Post;

@Repository
public interface PostDao extends JpaRepository<Post, Integer> {

}
