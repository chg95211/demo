package test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.junit.Test;

public class JavaDirLdapLocalTest {

	String url = "ldap://localhost:389";
	String username = "dc=manager,o=derek.com";
	String password = "derek";
	String baseDn = "ou=app,ou=root,o=derek.com";
	String root = "ou=java_tree";
	String organizational_unit = "ou=organizationalUnits";
	String position = "ou=positions";
	String user = "ou=users";
	String root_dn = root + "," + baseDn;
	String organizational_unit_dn = organizational_unit + "," + root_dn;
	String position_dn = position + "," + root_dn;
	String user_dn = user + "," + root_dn;

	public DirContext getContext() throws NamingException {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.SECURITY_PRINCIPAL, username);
		env.put(Context.SECURITY_CREDENTIALS, password);
		env.put(Context.SECURITY_AUTHENTICATION, "simple"); // "none", "simple", "strong"
		DirContext initial = new InitialDirContext(env);
		DirContext context = (DirContext) initial.lookup(url);
		return context;
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
			cleanRoot(root_dn);
			checkDn(organizational_unit_dn);
			checkDn(position_dn);
			checkDn(user_dn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void cleanRoot(String baseDn) throws NamingException {
		DirContext ldap = getContext();
		List<String> childs = getFolder(baseDn);
		if (childs != null && childs.size() > 0) {
			for (String ou : childs) {
				cleanRoot("ou=" + ou + "," + baseDn);
				System.out.println("unbind : " + "ou=" + ou + "," + baseDn);
				ldap.unbind("ou=" + ou + "," + baseDn);
			}
		} else {
			List<String> files = getFile(baseDn);
			for (String uid : files) {
				ldap.unbind("uid=" + uid + "," + baseDn);
				System.out.println("unbind : " + "uid=" + uid + "," + baseDn);
			}
		}
	}

	private List<String> getFolder(String baseDn) {
		try {
			DirContext ldap = getContext();
			String filters = "(objectClass=organizationalUnit)";
			String[] returnedAtts = { "ou" };
			SearchControls constraints = new SearchControls();
			constraints.setSearchScope(SearchControls.ONELEVEL_SCOPE);
			if (returnedAtts != null && returnedAtts.length > 0) {
				constraints.setReturningAttributes(returnedAtts);
			}
			NamingEnumeration en = ldap.search(baseDn, filters, constraints);
			if (en == null) {
				return null;
			}
			List<String> childs = new ArrayList<String>();
			while (en.hasMoreElements()) {
				Object obj = en.nextElement();
				if (obj instanceof SearchResult) {
					SearchResult sr = (SearchResult) obj;
					childs.add(sr.getAttributes().get("ou").get().toString());
				}
			}
			return childs;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<String> getFile(String baseDn) {
		try {
			DirContext ldap = getContext();

			String filters = "(objectClass=myUser)";
			String[] returnedAtts = { "uid" };
			SearchControls constraints = new SearchControls();
			constraints.setSearchScope(SearchControls.ONELEVEL_SCOPE);
			if (returnedAtts != null && returnedAtts.length > 0) {
				constraints.setReturningAttributes(returnedAtts);
			}
			NamingEnumeration en = ldap.search(baseDn, filters, constraints);
			if (en == null) {
				return null;
			}
			List<String> childs = new ArrayList<String>();
			while (en.hasMoreElements()) {
				Object obj = en.nextElement();
				if (obj instanceof SearchResult) {
					SearchResult sr = (SearchResult) obj;
					childs.add(sr.getAttributes().get("uid").get().toString());
				}
			}
			return childs;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Test
	public void sync() {
		try {
			clear();
			DirContext ldap = getContext();
			List<OrganizationalUnits> list1 = getOrganizational();
			for (OrganizationalUnits organizationalUnits : list1) {
				System.out.println(organizationalUnits.getDN(organizational_unit_dn));
				ldap.bind(organizationalUnits.getDN(organizational_unit_dn), null, organizationalUnits.buildAttributes());
				List<Positions> list2 = getPositions(organizationalUnits);
				for (Positions positions : list2) {
					System.out.println(positions.getDN(position_dn));
					ldap.bind(positions.getDN(position_dn), null, positions.buildAttributes());
					List<Users> list3 = getUsers(positions);
					for (Users users : list3) {
						System.out.println(users.getDN(user_dn));
						ldap.bind(users.getDN(user_dn), null, users.buildAttributes());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createBaseDn(String baseDn) {
		System.out.println("create dn : " + baseDn);
		try {
			DirContext ldap = getContext();
			Attributes attrs = new BasicAttributes();
			BasicAttribute objectClassAttrs = new BasicAttribute("objectClass");
			objectClassAttrs.add("organizationalUnit");
			attrs.put(objectClassAttrs);
			ldap.bind(baseDn, null, attrs);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public boolean checkExist(String baseDn) {
		boolean flag = false;
		try {
			DirContext ldap = getContext();
			Attributes returnAttr = ldap.getAttributes(baseDn,new String[] {"ou"});
			String ou = (String) returnAttr.get("ou").get();
			flag = (ou != null && ou.trim() != "");
		} catch (Exception e) {
			flag = false;
		}
		System.out.println(baseDn + " is exist : " + flag);
		return flag;
	}

	public void checkDn(String baseDn) {
		if (baseDn.indexOf(",") != -1) {
			if (!checkExist(baseDn)) {
				String fatherDn = baseDn.substring(baseDn.indexOf(",") + 1);
				checkDn(fatherDn);
				createBaseDn(baseDn);
			}
		}
	}
}
