package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

}
