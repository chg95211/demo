package test;

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

public class LdapLocalTest {

	String url = "ldap://localhost:389";
	String username = "dc=manager,o=derek.com";
	String password = "derek";
	String baseDn = "ou=app,ou=root,o=derek.com";
	String root = "ou=test_tree";
	String organizational_unit = "ou=organizationalUnits";
	String position = "ou=positions";
	String user = "ou=users";
	String organizational_unit_dn = organizational_unit + "," + root + "," + baseDn;
	String position_dn = position + "," + root + "," + baseDn;
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

	private List<OrganizationalUnits> getOrganizational() {
		List<OrganizationalUnits> list = new ArrayList<OrganizationalUnits>();
		OrganizationalUnits bean = null;
		for (int i = 0; i < 1; i++) {
			bean = new OrganizationalUnits();
			bean.setId("O_" + i);
			bean.setName("Name_" + i);
			list.add(bean);
		}
		return list;
	}

	private List<Positions> getPositions(OrganizationalUnits father) {
		List<Positions> list = new ArrayList<Positions>();
		Positions bean = null;
		for (int i = 0; i < 1; i++) {
			bean = new Positions();
			bean.setId("P_" + i + "_" + father.getId());
			bean.setName("Name_" + i);
			bean.setMyMemberOf(father.getDN(organizational_unit_dn));
			list.add(bean);
		}
		return list;
	}

	private List<Users> getUsers(Positions father) {
		List<Users> list = new ArrayList<Users>();
		Users bean = null;
		for (int i = 0; i < 1; i++) {
			bean = new Users();
			bean.setId("U_" + i + "_" + father.getId());
			bean.setName("Name_" + i);
			bean.setMyMemberOf(father.getDN(position_dn));
			bean.setMyUserPassword("pass2015");
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
	public void clear() {
		try {
			LdapTemplate ldapTemplate = getLocalhostLdapTemplate(baseDn);
			try {
				ldapTemplate.setIgnoreNameNotFoundException(true);
				ldapTemplate.unbind(root, true);
			} catch (Exception e) {

			}
			Attributes attrs = new BasicAttributes();
			BasicAttribute objectClassAttrs = new BasicAttribute("objectClass");
			objectClassAttrs.add("organizationalUnit");
			attrs.put(objectClassAttrs);
			ldapTemplate.bind(root, null, attrs);
			checkDn(organizational_unit_dn);
			checkDn(position_dn);
			checkDn(user_dn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void sync() {
		try {
			clear();
			LdapTemplate ldapTemplate1 = getLocalhostLdapTemplate(organizational_unit_dn);
			LdapTemplate ldapTemplate2 = getLocalhostLdapTemplate(position_dn);
			LdapTemplate ldapTemplate3 = getLocalhostLdapTemplate(user_dn);
			List<OrganizationalUnits> list1 = getOrganizational();
			for (OrganizationalUnits organizationalUnits : list1) {
				System.out.println(organizationalUnits.getDN(organizational_unit_dn));
				ldapTemplate1.bind(organizationalUnits.getUID(), null, organizationalUnits.buildAttributes());
				List<Positions> list2 = getPositions(organizationalUnits);
				for (Positions positions : list2) {
					System.out.println(positions.getDN(position_dn));
					ldapTemplate2.bind(positions.getUID(), null, positions.buildAttributes());
					List<Users> list3 = getUsers(positions);
					for (Users users : list3) {
						System.out.println(users.getDN(user_dn));
						ldapTemplate3.bind(users.getUID(), null, users.buildAttributes());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createBaseDn(String ou, String baseDn) {
		System.out.println("create dn : " + ou + "," + baseDn);
		LdapTemplate ldapTemplate = getLocalhostLdapTemplate(baseDn);
		Attributes attrs = new BasicAttributes();
		BasicAttribute objectClassAttrs = new BasicAttribute("objectClass");
		objectClassAttrs.add("organizationalUnit");
		attrs.put(objectClassAttrs);
		ldapTemplate.bind(ou, null, attrs);
	}

	public void checkBaseDn(String baseDn) {
		String[] args = baseDn.split(",");
		String fatherDn = args[args.length - 1];
		for (int i = args.length - 2; i >= 0; i--) {
			String checkDn = args[i];
			if (!checkExist(checkDn, fatherDn)) {
				createBaseDn(checkDn, fatherDn);
			}
			fatherDn = checkDn + "," + fatherDn;
		}
	}

	public boolean checkExist(String checkDn, String fatherDn) {
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

	public void checkDn(String baseDn) {
		if (baseDn.indexOf(",") != -1) {
			String checkDn = baseDn.substring(0, baseDn.indexOf(","));
			String fatherDn = baseDn.substring(baseDn.indexOf(",") + 1);
			if (!checkExist(checkDn, fatherDn)) {
				checkDn(fatherDn);
				createBaseDn(checkDn, fatherDn);
			}
		}
	}
}
