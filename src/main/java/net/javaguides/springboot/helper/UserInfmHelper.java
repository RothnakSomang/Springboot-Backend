package net.javaguides.springboot.helper;

public interface UserInfmHelper {
	byte[] getGenerateSalt();
	byte[] getHashWithSalt(String pwd, String salt );
	byte[] getHashWithSalt(String pwd, byte[] salt );
	String byteToString(byte[] input);
	byte[] stringToByte(String input);
}
