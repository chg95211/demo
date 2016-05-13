package com.chj.data.domain.ldap;

import java.io.Serializable;

import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entry(objectClasses = { "inetOrgPerson" }, base = "ou=ou1,dc=test,dc=com")
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestLdapDomain implements Serializable, BaseLdapDomain<String> {

	private static final long serialVersionUID = 1L;

	@Id
	@JsonIgnore
	protected Name rdn;

	@DnAttribute(value = "uid")
	protected String uid;

	@Attribute(name = "nickname")
	private String nickName;

	@Attribute(name = "realname")
	private String realName;

	@Attribute(name = "gender")
	private String gender;

	@Attribute(name = "birthday")
	private String birthday;

	@Attribute(name = "qq")
	private String qq;

	@Attribute(name = "msn")
	private String msn;

	@Attribute(name = "zipCode")
	private String zipCode;

	@Attribute(name = "userPassword")
	private String userPassword;

	@Override
	public String getUid() {
		return this.uid;
	}

	@Override
	public void setRdn(Name rnd) {
		this.rdn = rnd;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}
