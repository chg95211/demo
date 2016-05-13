package com.chj.dao.ldap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Component;

import com.chj.dao.ldap.base.BaseLdapDaoImpl;
import com.chj.data.domain.ldap.TestLdapDomain;

@Component
public class TestLdapDaoImpl extends BaseLdapDaoImpl<TestLdapDomain, String> implements
		TestLdapDao {

	@Autowired
	public TestLdapDaoImpl(@Value("com.chj.data.domain.ldap.TestLdapDomain")Class<TestLdapDomain> clazz) {
		super(clazz);
	}
	
	@Resource(name="test_ldap")
	@Override
	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}

}
