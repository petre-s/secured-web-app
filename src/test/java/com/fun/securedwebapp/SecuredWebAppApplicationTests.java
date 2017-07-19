package com.fun.securedwebapp;

import com.fun.db.Authority;
import com.fun.db.TagRepository;
import com.fun.db.User;
import com.fun.db.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")

public class SecuredWebAppApplicationTests {

	@Autowired
	TagRepository tagRepository;

	@Autowired
	UserRepository userRepository;

	@Test
	@Transactional
	public void JpaSmoke() {
		User user = new User("test", "hashedpassword", "user@email.com", true,
				Arrays.asList(new Authority("ROLE_USER")));

		userRepository.save(user);

		user  = userRepository.findAll().iterator().next();
		Assert.assertTrue(user.getUsername().equals("test"));
	}

}
