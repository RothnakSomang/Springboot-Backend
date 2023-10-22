package net.javaguides.springboot.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="user_infm")
public class UserInfm {
	@Id
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "user_nm")
	private String userNm;

	@Column(name = "salt")
	private String salt;

	@Column(name = "pwd")
	private String pwd;

	@Column(name = "reg_dtm")
	private String regDtm;

	@Column(name = "mod_dtm")
	private String modDtm;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRegDtm() {
		return regDtm;
	}

	public void setRegDtm(String regDtm) {
		this.regDtm = regDtm;
	}

	public String getModDtm() {
		return modDtm;
	}

	public void setModDtm(String modDtm) {
		this.modDtm = modDtm;
	}

	@Override
	public String toString() {
		return "UserInfm [userId=" + userId + ", userNm=" + userNm + ", salt=" + salt + ", pwd=" + pwd + ", regDtm="
				+ regDtm + ", modDtm=" + modDtm + "]";
	}
	
}
