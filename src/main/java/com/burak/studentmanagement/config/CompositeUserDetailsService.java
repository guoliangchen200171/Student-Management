package com.burak.studentmanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.burak.studentmanagement.service.StudentService;
import com.burak.studentmanagement.service.TeacherService;

@Service
@Primary
public class CompositeUserDetailsService implements UserDetailsService {

	@Autowired
	private StudentService studentService;

	@Autowired
	private TeacherService teacherService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			return studentService.loadUserByUsername(username);
		} catch (UsernameNotFoundException studentNotFound) {
			return teacherService.loadUserByUsername(username);
		}
	}
}
