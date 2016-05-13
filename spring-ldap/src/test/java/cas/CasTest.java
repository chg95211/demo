package cas;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;

import org.junit.Test;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

public class CasTest {
	String url = "ldap://localhost:389";
	String username = "dc=manager,o=derek.com";
	String password = "derek";
	String baseDn = "ou=app,ou=root,o=derek.com";
	String root = "ou=cas_test";
	String user = "ou=users";
	String user_dn = user + "," + root + "," + baseDn;

	private LdapTemplate getLocalhostLdapTemplate(String baseDN) {
		LdapContextSource dsscs = new LdapContextSource();
		dsscs.setUrl(url);
		dsscs.setUserDn(username);
		dsscs.setPassword(password);
		dsscs.setBase(baseDN);
		dsscs.afterPropertiesSet();
		LdapTemplate ldapTemplate_local = new LdapTemplate();
		ldapTemplate_local.setContextSource(dsscs);
		return ldapTemplate_local;
	}

	private boolean checkExist(String checkDn, String fatherDn) {
		boolean flag = false;
		try {
			LdapTemplate ldapTemplate = getLocalhostLdapTemplate(fatherDn);
			List<String> list = ldapTemplate.search("", checkDn, new AttributesMapper<String>() {
				@Override
				public String mapFromAttributes(Attributes attributes) throws NamingException {
					return attributes.get("ou").get().toString();
				}
			});
			flag = list != null && list.size() == 1;
		} catch (Exception e) {
			flag = false;
		}
		System.out.println(checkDn + "," + fatherDn + " is exist : " + flag);
		return flag;
	}

	private void checkDn(String baseDn) {
		if (baseDn.indexOf(",") != -1) {
			String checkDn = baseDn.substring(0, baseDn.indexOf(","));
			String fatherDn = baseDn.substring(baseDn.indexOf(",") + 1);
			if (!checkExist(checkDn, fatherDn)) {
				checkDn(fatherDn);
				createBaseDn(checkDn, fatherDn);
			}
		}
	}

	private void createBaseDn(String ou, String baseDn) {
		System.out.println("create dn : " + ou + "," + baseDn);
		LdapTemplate ldapTemplate = getLocalhostLdapTemplate(baseDn);
		Attributes attrs = new BasicAttributes();
		BasicAttribute objectClassAttrs = new BasicAttribute("objectClass");
		objectClassAttrs.add("organizationalUnit");
		attrs.put(objectClassAttrs);
		ldapTemplate.bind(ou, null, attrs);
	}

	private List<CasUsers> getUsers() {
		List<CasUsers> list = new ArrayList<CasUsers>();
		CasUsers bean = null;
		for (int i = 0; i < 10; i++) {
			bean = new CasUsers();
			bean.setId("U00" + i);
			bean.setName("Name_" + bean.getId());
			bean.setUserPassword("pass2015");
			if (i % 2 == 1) {
				bean.setMyRole("ROLE_ADMIN");
			} else {
				bean.setMyRole("ROLE_USER");
			}
			list.add(bean);
		}
		return list;
	}

	@Test
	public void clear1() {
		try {
			LdapTemplate ldapTemplate = getLocalhostLdapTemplate("ou=root,o=derek.com");
			ldapTemplate.setIgnoreNameNotFoundException(true);
			ldapTemplate.unbind("ou=app", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void clear() {
		try {
			LdapTemplate ldapTemplate = getLocalhostLdapTemplate("ou=root,o=derek.com");
			ldapTemplate.setIgnoreNameNotFoundException(true);
			ldapTemplate.unbind("ou=app", true);
			checkDn(user_dn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void casCreateUsers() {
		try {
			LdapTemplate ldapTemplate = getLocalhostLdapTemplate(user_dn);
			List<CasUsers> list3 = getUsers();
			for (CasUsers users : list3) {
				ldapTemplate.bind(users.getUID(), null, users.buildAttributes());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
