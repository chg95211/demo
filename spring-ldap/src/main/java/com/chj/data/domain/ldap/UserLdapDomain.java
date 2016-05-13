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

@Entry(objectClasses = { "top", "person", "organizationalPerson", "inetOrgPerson", "sodw" }, base = "ou=onstaruser,o=shanghaionstar.com")
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLdapDomain implements Serializable, BaseLdapDomain<String> {

	private static final long serialVersionUID = 1L;

	@Id
	@JsonIgnore
	protected Name rdn;

	@DnAttribute(value = "uid")
	protected String uid;

	@Attribute(name = "mail")
	private String email;

	@Attribute(name = "mobile")
	private String mobile;

	@Attribute(name = "sodw-role")
	private String sodwRole;

	@Attribute(name = "sodw-governmentid")
	private String sodwGovernmentid;

	@Attribute(name = "isEnabled")
	private String isEnabled;

	@Attribute(name = "sodw-type")
	private String sodwType;

	@Attribute(name = "subscriberid")
	private String subscriberId;

	@Attribute(name = "isRemindPackageExpire")
	private String isRemindPackageExpire;

	@Attribute(name = "sodw-ssa-flag")
	private String sodwSsaFlag;

	@Attribute(name = "sodw-first-flag")
	private String sodwFirstFlag;

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

	@Attribute(name = "accountnum")
	private String accountNum;

	@Attribute(name = "billingAddress")
	private String billingAddress;

	@Attribute(name = "zipCode")
	private String zipCode;

	@Attribute(name = "VIN")
	private String vin;

	@Attribute(name = "userPassword")
	private String userPassword;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String getUid() {
		return this.uid;
	}

	@Override
	public void setRdn(Name rdn) {
		this.rdn = rdn;
	}

	public String getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(String isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getSodwType() {
		return sodwType;
	}

	public void setSodwType(String sodwType) {
		this.sodwType = sodwType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSodwRole() {
		return sodwRole;
	}

	public void setSodwRole(String sodwRole) {
		this.sodwRole = sodwRole;
	}

	public String getSodwGovernmentid() {
		return sodwGovernmentid;
	}

	public void setSodwGovernmentid(String sodwGovernmentid) {
		this.sodwGovernmentid = sodwGovernmentid;
	}

	public String getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}

	public String getIsRemindPackageExpire() {
		return isRemindPackageExpire;
	}

	public void setIsRemindPackageExpire(String isRemindPackageExpire) {
		this.isRemindPackageExpire = isRemindPackageExpire;
	}

	public String getSodwSsaFlag() {
		return sodwSsaFlag;
	}

	public void setSodwSsaFlag(String sodwSsaFlag) {
		this.sodwSsaFlag = sodwSsaFlag;
	}

	public String getSodwFirstFlag() {
		return sodwFirstFlag;
	}

	public void setSodwFirstFlag(String sodwFirstFlag) {
		this.sodwFirstFlag = sodwFirstFlag;
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

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
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
