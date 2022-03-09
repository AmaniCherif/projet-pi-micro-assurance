package tn.esprit.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.Interface.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  UserService userService;
 
  @GetMapping("/retrieveAllUsers")

  public List<User> getUsers(){
	  List<User> listUsers=userService.retrieveAllUsers();
	  return listUsers;
  }
  @GetMapping("/retrieveUser/{user-id}")
  
  public User retrieveUser(@PathVariable("user-id") Long userId) {
	  return userService.retrieveUser(userId);
  }
  @PostMapping("/addUser")

  public User addUser(@RequestBody User u)
  {
	  User user = userService.addUser(u);
  return user;
  }
  @PutMapping("/modify-user")
  
  public User modifyUser(@RequestBody User user) {
  return userService.updateUser(user);
  }
  @DeleteMapping("/remove-user/{user-id}")
  public void removeUser (@PathVariable("user-id")Long userId) {
	  userService.deleteUser(userId);
  }  

}