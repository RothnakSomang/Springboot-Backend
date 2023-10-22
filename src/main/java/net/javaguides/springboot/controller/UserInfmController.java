package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.UserInfm;
import net.javaguides.springboot.service.UserInfmService;

@RestController
@RequestMapping("/api/userInfm")
public class UserInfmController {
	UserInfmService userInfmService;

	public UserInfmController(UserInfmService userinfmService) {
		super();
		this.userInfmService = userinfmService;
	}
	
	//Register UserInfm
	@PostMapping("/registerUserInfm")
	public ResponseEntity<UserInfm> saveUserInfm(@RequestBody UserInfm userInfm){

		System.out.println("--2 userRegister-- userInfm:"+ userInfm.toString());
		return new ResponseEntity<UserInfm>(userInfmService.userRegister(userInfm), HttpStatus.CREATED);
	}
	
	//Get All UserInfm
	@GetMapping("findAllUserInfm")
	public List<UserInfm> getUserInfm(){
		return userInfmService.getUserInfm();
	}
	
	@GetMapping("/userLogin")
	public ResponseEntity<UserInfm> login (@RequestBody UserInfm userInfm){
		System.out.println("--3 UserLogin-- userInfm:"+ userInfm.toString());
		return new ResponseEntity<UserInfm>(userInfmService.userLogin(userInfm),HttpStatus.OK);
	}
	
	

}
