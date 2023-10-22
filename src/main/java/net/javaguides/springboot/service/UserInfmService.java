package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.UserInfm;

public interface UserInfmService {
	UserInfm userRegister(UserInfm userInfm);
	UserInfm userLogin(UserInfm userInfm);
	UserInfm userUpdate(UserInfm userInfm);
	List<UserInfm> getUserInfm();
	UserInfm findUserInfm(String UserId);

}
