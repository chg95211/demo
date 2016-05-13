package com.chj.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chj.constants.Constants;
import com.chj.data.domain.ldap.BaseLdapDomain;
import com.chj.data.domain.ldap.TestLdapDomain;
import com.chj.data.domain.ldap.UserLdapDomain;
import com.chj.service.ldap.TestLdapService;
import com.chj.service.ldap.UserLdapService;
import com.chj.utils.JsonUtil;

@Controller
@RequestMapping("ldap")
public class LdapResource {

	final static Logger logger = LoggerFactory.getLogger(LdapResource.class);

	@Autowired
	private UserLdapService userLdapService;
	
	@Autowired
	private TestLdapService testLdapService;

	@RequestMapping(value = "get/{uid}", method = RequestMethod.GET, produces = Constants.REST_APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<?> getByUid(@PathVariable("uid") String uid) {
		try {
			logger.info("getUserByUid request : {} ", uid);
			UserLdapDomain bean1 = userLdapService.get(uid);
			logger.info("getUserByUid response : {} ", JsonUtil.getJson(bean1));
			TestLdapDomain bean2 = testLdapService.get(uid);
			logger.info("getUserByUid response : {} ", JsonUtil.getJson(bean2));
			return new ResponseEntity<BaseLdapDomain<String>>(bean2, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "update/{uid}", method = RequestMethod.GET, produces = Constants.REST_APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<?> updateByUid(@PathVariable("uid") String uid) {
		try {
			logger.info("getUserByUid request : {} ", uid);
			TestLdapDomain bean = testLdapService.get(uid);
			logger.info("getUserByUid response : {} ", JsonUtil.getJson(bean));
			bean.setUserPassword("test222222");
			bean = testLdapService.update(bean);
			logger.info("getUserByUid response : {} ", JsonUtil.getJson(bean));
			return new ResponseEntity<BaseLdapDomain<String>>(bean, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
