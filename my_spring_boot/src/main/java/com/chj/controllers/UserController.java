package com.chj.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chj.dao.UserDao;
import com.chj.domain.UserDomain;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired(required = false)
	UserDao userDao;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	UserDomain get(@PathVariable("id") String id) {
		return userDao.findOne(Integer.valueOf(id));
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	String create() {
		UserDomain user = new UserDomain();
		user.setUserName("derek!");
		userDao.save(user);
		return "create!";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	String delete(@PathVariable("id") String id) {
		userDao.delete(Integer.valueOf(id));
		return "delete!";
	}
}
