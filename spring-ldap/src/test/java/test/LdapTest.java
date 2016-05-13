package test;

import java.util.List;

import org.junit.Test;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

import com.chj.dao.ldap.base.BaseLdapDao;
import com.chj.dao.ldap.base.BaseLdapDaoImpl;
import com.chj.data.domain.ldap.TestLdapDomain;
import com.chj.data.domain.ldap.UserLdapDomain;
import com.chj.utils.JsonUtil;

public class LdapTest {

	String url = "ldap://localhost:389";
	String username = "dc=manager,o=derek.com";
	String password = "derek";
	
	String idt2_url = "ldap://ldap.idt2.shanghaionstar.com:389";
	String idt2_username = "uid=onstaruser,ou=user,ou=COMMON,ou=app,o=shanghaionstar.com";
	String idt2_password = "aspi41Rr";

	String pp1_url = "ldap://lldap.pp1.shanghaionstar.com:389";
	String pp1_username = "uid=portal,ou=user,ou=COMMON,ou=app,o=shanghaionstar.com";
	String pp1_password = "aspi41Rr";
	
	String efo_url = "ldap://lldap.ef.shanghaionstar.com:389";
	String efo_username = "uid=portal,ou=user,ou=COMMON,ou=app,o=shanghaionstar.com";
	String efo_password = "UGD6SOpG";
	
	private LdapTemplate getLocalhostLdapTemplate() {
		LdapContextSource dsscs = new LdapContextSource();
		dsscs.setUrl(url);
		dsscs.setUserDn(username);
		dsscs.setPassword(password);
		dsscs.afterPropertiesSet();
		LdapTemplate ldapTemplate_local = new LdapTemplate();
		ldapTemplate_local.setContextSource(dsscs);
		return ldapTemplate_local;
	}

	
	private BaseLdapDao<TestLdapDomain, String> getLocalhost() {
		LdapContextSource dsscs = new LdapContextSource();
		dsscs.setUrl(url);
		dsscs.setUserDn(username);
		dsscs.setPassword(password);
		dsscs.afterPropertiesSet();
		LdapTemplate ldapTemplate_local = new LdapTemplate();
		ldapTemplate_local.setContextSource(dsscs);
		BaseLdapDaoImpl<TestLdapDomain, String> ldapDao = new BaseLdapDaoImpl<TestLdapDomain, String>(TestLdapDomain.class);
		ldapDao.setLdapTemplate(ldapTemplate_local);
		return ldapDao;
	}

	private BaseLdapDao<UserLdapDomain, String> getPP1() {
		LdapContextSource dsscs = new LdapContextSource();
		dsscs.setUrl(pp1_url);
		dsscs.setUserDn(pp1_username);
		dsscs.setPassword(pp1_password);
		dsscs.afterPropertiesSet();
		LdapTemplate ldapTemplate_local = new LdapTemplate();
		ldapTemplate_local.setContextSource(dsscs);
		BaseLdapDaoImpl<UserLdapDomain, String> ldapDao = new BaseLdapDaoImpl<UserLdapDomain, String>(UserLdapDomain.class);
		ldapDao.setLdapTemplate(ldapTemplate_local);
		return ldapDao;
	}
	
	private BaseLdapDao<UserLdapDomain, String> getEFO() {
		LdapContextSource dsscs = new LdapContextSource();
		dsscs.setUrl(efo_url);
		dsscs.setUserDn(efo_username);
		dsscs.setPassword(efo_password);
		dsscs.afterPropertiesSet();
		LdapTemplate ldapTemplate_local = new LdapTemplate();
		ldapTemplate_local.setContextSource(dsscs);
		BaseLdapDaoImpl<UserLdapDomain, String> ldapDao = new BaseLdapDaoImpl<UserLdapDomain, String>(UserLdapDomain.class);
		ldapDao.setLdapTemplate(ldapTemplate_local);
		return ldapDao;
	}
	
	private BaseLdapDao<UserLdapDomain, String> getIDT2() {
		LdapContextSource dsscs = new LdapContextSource();
		dsscs.setUrl(idt2_url);
		dsscs.setUserDn(idt2_username);
		dsscs.setPassword(idt2_password);
		dsscs.afterPropertiesSet();
		LdapTemplate ldapTemplate_local = new LdapTemplate();
		ldapTemplate_local.setContextSource(dsscs);
		BaseLdapDaoImpl<UserLdapDomain, String> ldapDao = new BaseLdapDaoImpl<UserLdapDomain, String>(UserLdapDomain.class);
		ldapDao.setLdapTemplate(ldapTemplate_local);
		return ldapDao;
	}
	
	@Test
	public void test1() {
		BaseLdapDao<TestLdapDomain, String> ldapDao = getLocalhost();
		System.out.println(JsonUtil.getJson(ldapDao.get("test1")));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test11() {
		LdapTemplate ldapTemplate = getLocalhostLdapTemplate();
		ldapTemplate.unbind(new DistinguishedName("ou=wechat,ou=app,ou=root,o=derek.com"),true);
	}
	

	@Test
	public void test2() {
		BaseLdapDao<UserLdapDomain, String> ldapDao =getPP1();
		System.out.println(JsonUtil.getJson(ldapDao.get("GEN80626")));
	}
	
	@Test
	public void test3() {
		BaseLdapDao<UserLdapDomain, String> ldapDao =getPP1();
		System.out.println(JsonUtil.getJson(ldapDao.get("GEN80626")));
	}
	
	@Test
	public void test4() {
		BaseLdapDao<UserLdapDomain, String> ldapDao =getEFO();
		UserLdapDomain bean = ldapDao.get("TEST0916");
		System.out.println(JsonUtil.getJson(bean));
//		bean.setVin("test0001");
//		ldapDao.update(bean);
//		bean = ldapDao.get("TEST0916");
//		System.out.println(JsonUtil.getJson(bean));
	}
	
	@Test
	public void test5() {
		BaseLdapDao<UserLdapDomain, String> ldapDao =getIDT2();
		UserLdapDomain bean = ldapDao.get("onstarm41287145");
		System.out.println(JsonUtil.getJson(bean));
		//bean.setSubscriberId("00000000000108160416_00000001447665981521_00050"+"_");
		bean.setAccountNum(null);
		bean.setVin(null);
		ldapDao.update(bean);
		bean = ldapDao.get("onstarm22722144");
		System.out.println(JsonUtil.getJson(bean));
	}
	
	@Test
	public void test6() {
		BaseLdapDao<UserLdapDomain, String> ldapDao =getPP1();
		List<UserLdapDomain> bean = ldapDao.findByProperty("subscriberid", "00000000000161536523_00000001455694212669_00003");
		System.out.println(JsonUtil.getJson(bean));
	}


}
