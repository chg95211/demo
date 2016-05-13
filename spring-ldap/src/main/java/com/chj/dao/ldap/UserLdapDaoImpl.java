package com.chj.dao.ldap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Component;

import com.chj.dao.ldap.base.BaseLdapDaoImpl;
import com.chj.data.domain.ldap.UserLdapDomain;

@Component
public class UserLdapDaoImpl extends BaseLdapDaoImpl<UserLdapDomain, String> implements
		UserLdapDao {

	@Autowired
	public UserLdapDaoImpl(@Value("com.chj.data.domain.ldap.UserLdapDomain")Class<UserLdapDomain> clazz) {
		super(clazz);
	}

	@Resource(name="idt2_ldap")
	@Override
	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}

}
