package com.chj.service.ldap.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.chj.dao.ldap.TestLdapDao;
import com.chj.data.domain.ldap.TestLdapDomain;
import com.chj.service.ldap.LdapDetailsMapper;
import com.chj.service.ldap.TestLdapService;

@Service
public class TestLdapServiceImpl extends BaseLdapServiceImpl<TestLdapDomain, String> implements TestLdapService, LdapDetailsMapper<TestLdapDomain> {

	private TestLdapDao testLdapDao;

	@Autowired
	public TestLdapServiceImpl(TestLdapDao testLdapDao) {
		this.baseDao = this.testLdapDao = testLdapDao;
	}

	@Override
	public TestLdapDomain mapping(String username) {
		List<TestLdapDomain> domains = testLdapDao.findByProperty("uid", username);
		if (CollectionUtils.isEmpty(domains)) {
			return null;
		}
		return domains.get(0);
	}

}