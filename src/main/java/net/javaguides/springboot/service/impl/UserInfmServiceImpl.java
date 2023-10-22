package net.javaguides.springboot.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.helper.UserInfmHelperImpl;
import net.javaguides.springboot.model.UserInfm;
import net.javaguides.springboot.repository.UserInfmRepository;
import net.javaguides.springboot.service.UserInfmService;

@Service
public class UserInfmServiceImpl implements UserInfmService {
	UserInfmRepository userInfmRepository;
	

	public UserInfmServiceImpl(UserInfmRepository userInfmRepository) {
		super();
		this.userInfmRepository = userInfmRepository;
	}

	@Override
	public UserInfm userRegister(UserInfm userInfm) {
		// TODO Auto-generated method stub
		UserInfmHelperImpl userInfmHelperImpl = new UserInfmHelperImpl();
		System.out.println("--1 userRegister-- userInfm:"+ userInfm.toString());
		if(userInfm.getPwd() != null) {
			String salt = userInfmHelperImpl.byteToString(userInfmHelperImpl.getGenerateSalt());
			userInfm.setSalt(salt);
			userInfm.setPwd(userInfmHelperImpl.byteToString(userInfmHelperImpl.getHashWithSalt(userInfm.getPwd(), salt)));
		}

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
		LocalDateTime now = LocalDateTime.now();  
		userInfm.setRegDtm(dtf.format(now));
		userInfm.setModDtm(dtf.format(now));

		System.out.println("--2 userRegister-- userInfm:"+ userInfm.toString());
		//return null;

		return userInfmRepository.save(userInfm);
	}

	@Override
	public UserInfm userLogin(UserInfm userInfm) {
		// TODO Auto-generated method stub
		UserInfm userInfmLogin = new UserInfm();
		if(userInfm.getUserId() != null && userInfm.getPwd() != null) {
			UserInfmHelperImpl userInfmHelperImpl = new UserInfmHelperImpl();
			UserInfm userInfmDb = userInfmRepository.findById(userInfm.getUserId()).orElseThrow(()-> new ResourceNotFoundException("UserInfm", "UserId", userInfm.getUserId()));
			String salt = "";
			if(userInfmDb != null) {
				salt = userInfmDb.getSalt();
				userInfm.setPwd(userInfmHelperImpl.byteToString(userInfmHelperImpl.getHashWithSalt(userInfm.getPwd(), salt)));
				userInfmLogin = userInfmRepository.findByUserIdAndPwd(userInfm.getUserId(), userInfm.getPwd());
				System.out.println("--- userInfmLogin: "+ userInfmLogin);
			}
		
		}
		return userInfmLogin;
	}

	@Override
	public UserInfm userUpdate(UserInfm userInfm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfm> getUserInfm() {
		// TODO Auto-generated method stub
		return userInfmRepository.findAll();
	}

	@Override
	public UserInfm findUserInfm(String UserId) {
		// TODO Auto-generated method stub
		return userInfmRepository.findById(UserId).orElseThrow(()-> new ResourceNotFoundException("UserInfm", "UserId", UserId));
	}

}
