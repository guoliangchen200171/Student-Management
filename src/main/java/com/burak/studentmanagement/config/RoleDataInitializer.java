package com.burak.studentmanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.burak.studentmanagement.dao.RoleDao;
import com.burak.studentmanagement.entity.Role;

@Component
public class RoleDataInitializer implements CommandLineRunner {

	@Autowired
	private RoleDao roleDao;

	@Override
	public void run(String... args) {
		ensureRoleExists("ROLE_STUDENT");
		ensureRoleExists("ROLE_TEACHER");
	}

	private void ensureRoleExists(String roleName) {
		if (roleDao.findRoleByName(roleName) == null) {
			roleDao.save(new Role(roleName));
		}
	}
}
