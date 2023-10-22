package net.javaguides.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.UserInfm;

public interface UserInfmRepository extends JpaRepository<UserInfm, String>{
	UserInfm findByUserIdAndPwd(String userId, String pwd);

}
