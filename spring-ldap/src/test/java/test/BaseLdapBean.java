package test;

import javax.naming.directory.Attributes;

public abstract class BaseLdapBean {

	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUID() {
		return "uid=" + id;
	}

	public String getDN(String baseDN) {
		return getUID() + "," + baseDN;
	}

	public abstract Attributes buildAttributes();

}
