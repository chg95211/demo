package com.chj.service.ldap;


public interface LdapDetailsMapper<T> {
	public T mapping(String  username);
}
