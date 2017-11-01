package com.nbenja.springdata.jpa.onetomanyrelation;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import com.nbenja.springdata.jpa.onetomanyrelation.domain.Group;
import com.nbenja.springdata.jpa.onetomanyrelation.domain.User;
import com.nbenja.springdata.jpa.onetomanyrelation.repository.GroupRepository;
import com.nbenja.springdata.jpa.onetomanyrelation.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OneToManyApplication.class)
public class OneToManyApplicationIT {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private GroupRepository groupRepository;

	@Before
	public void before() {
		User user = new User();
		user.setFirstName("Tom");
		user.setLastName("Jerry");
		user.setUserName("tomAndJerry");
		user.setPassword("password");
		userRepository.save(user);

		Group group = new Group();
		group.setGroupName("TestGroup");
		group.setUser(user);
		groupRepository.save(group);
	}

	@Test
	public void oneToMany_validateResults_afterDbInsertion() {
		User actual = userRepository.findByFirstNameAndLastName("Tom", "Jerry");
		assertThat(actual, is(notNullValue()));
	}

}
