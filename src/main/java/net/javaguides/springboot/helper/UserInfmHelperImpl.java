package net.javaguides.springboot.helper;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import org.apache.commons.codec.digest.DigestUtils;

public class UserInfmHelperImpl implements UserInfmHelper {

	@Override
	public byte[] getGenerateSalt() {
		// TODO Auto-generated method stub
		SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        return bytes;
	}

	@Override
	public byte[] getHashWithSalt(String pwd, String salt ) {
		// TODO Auto-generated method stub
		return DigestUtils.sha512(pwd + salt);
	}

	@Override
	public String byteToString(byte[] input) {
		// TODO Auto-generated method stub
		return Base64.getEncoder().encodeToString(input);
	}

	@Override
	public byte[] stringToByte(String input) {
		// TODO Auto-generated method stub
		return Base64.getDecoder().decode(input);
	}

	@Override
	public byte[] getHashWithSalt(String pwd, byte[] salt) {
		// TODO Auto-generated method stub
		String saltStr = byteToString(salt);
		return DigestUtils.sha512(pwd + saltStr);
	}
	
	public static void main(String args[]) {
		UserInfmHelperImpl userInfmHelperImpl = new UserInfmHelperImpl();
		byte[] salt = userInfmHelperImpl.getGenerateSalt();
		String saltStr = userInfmHelperImpl.byteToString(salt);
		String pwd = "11111111";
		
		System.out.println("1."+ salt);
		System.out.println("1."+ saltStr);
		

		System.out.println("2."+ pwd + saltStr);
		byte[] hash = userInfmHelperImpl.getHashWithSalt(pwd, saltStr);
		String hashStr = userInfmHelperImpl.byteToString(hash);
		System.out.println("2."+ hash);
		System.out.println("2."+ hashStr);
		

		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));  
	}

}
