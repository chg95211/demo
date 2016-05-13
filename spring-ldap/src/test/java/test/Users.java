package test;

import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;

import org.springframework.util.StringUtils;

public class Users extends BaseLdapBean {

	private String departmentNumber;
	private String displayName;
	private String employeeNumber;
	private String employeeType;
	private String givenName;
	private String homePhone;
	private String homePostalAddress;
	private String mobile;
	private String mail;
	private String myUserName;
	private String myMemberOf;
	private String myRole;
	private String myUserPassword;

	public String getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(String departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getHomePostalAddress() {
		return homePostalAddress;
	}

	public void setHomePostalAddress(String homePostalAddress) {
		this.homePostalAddress = homePostalAddress;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMyUserName() {
		return myUserName;
	}

	public void setMyUserName(String myUserName) {
		this.myUserName = myUserName;
	}

	public String getMyMemberOf() {
		return myMemberOf;
	}

	public void setMyMemberOf(String myMemberOf) {
		this.myMemberOf = myMemberOf;
	}

	public String getMyRole() {
		return myRole;
	}

	public void setMyRole(String myRole) {
		this.myRole = myRole;
	}

	public String getMyUserPassword() {
		return myUserPassword;
	}

	public void setMyUserPassword(String myUserPassword) {
		this.myUserPassword = myUserPassword;
	}

	@Override
	public Attributes buildAttributes() {
		Attributes attributes = new BasicAttributes();
		Attribute objectClass = new BasicAttribute("objectClass");
		objectClass.add("myUser");
		attributes.put(objectClass);
		attributes.put("uid", getId());
		attributes.put("cn", getName());
		attributes.put("sn", getName());
		if (!StringUtils.isEmpty(this.departmentNumber)) {
			attributes.put("departmentNumber", this.departmentNumber);
		}
		if (!StringUtils.isEmpty(this.displayName)) {
			attributes.put("displayName", this.displayName);
		}
		if (!StringUtils.isEmpty(this.employeeNumber)) {
			attributes.put("employeeNumber", this.employeeNumber);
		}
		if (!StringUtils.isEmpty(this.employeeType)) {
			attributes.put("employeeType", this.employeeType);
		}
		if (!StringUtils.isEmpty(this.givenName)) {
			attributes.put("givenName", this.givenName);
		}
		if (!StringUtils.isEmpty(this.homePhone)) {
			attributes.put("homePhone", this.homePhone);
		}
		if (!StringUtils.isEmpty(this.homePostalAddress)) {
			attributes.put("homePostalAddress", this.homePostalAddress);
		}
		if (!StringUtils.isEmpty(this.mail)) {
			attributes.put("mail", this.mail);
		}
		if (!StringUtils.isEmpty(this.mobile)) {
			attributes.put("mobile", this.mobile);
		}
		if (!StringUtils.isEmpty(this.myMemberOf)) {
			attributes.put("myMemberOf", this.myMemberOf);
		}
		if (!StringUtils.isEmpty(this.myUserName)) {
			attributes.put("myUserName", this.myUserName);
		}
		if (!StringUtils.isEmpty(this.myRole)) {
			attributes.put("myRole", this.myRole);
		}
		if (!StringUtils.isEmpty(this.myUserPassword)) {
			attributes.put("myUserPassword", this.myUserPassword);
		}
		return attributes;
	}
}
