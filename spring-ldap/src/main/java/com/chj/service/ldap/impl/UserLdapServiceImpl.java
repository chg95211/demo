package com.chj.service.ldap.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.chj.dao.ldap.UserLdapDao;
import com.chj.data.domain.ldap.UserLdapDomain;
import com.chj.service.ldap.LdapDetailsMapper;
import com.chj.service.ldap.UserLdapService;

@Service
public class UserLdapServiceImpl extends BaseLdapServiceImpl<UserLdapDomain, String> implements UserLdapService, LdapDetailsMapper<UserLdapDomain> {
	private UserLdapDao userLdapDao;

	@Autowired
	public UserLdapServiceImpl(UserLdapDao userLdapDao) {
		this.baseDao = this.userLdapDao = userLdapDao;
	}

	@Override
	public UserLdapDomain mapping(String username) {
		List<UserLdapDomain> domains = userLdapDao.findByProperty("uid", username);
		if (CollectionUtils.isEmpty(domains)) {
			return null;
		}
		return domains.get(0);
	}

}
