package com.nbenja.springdata.jpa.onetomanyrelation;

import static org.hamcrest.CoreMatchers.equalTo;
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

import java.util.Collections;

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
		user.setLastName("JerryTest");
		user.setUserName("tomAndJerryTest");
		user.setPassword("password");

		Group group = new Group("TestGroup", user);
		user.setGroups(Collections.singleton(group));
		userRepository.save(user);

	}

	@Test
	public void oneToMany_validateResults_afterDbInsertion() {
		User actual = userRepository.findByFirstNameAndLastName("Tom", "JerryTest");
		assertThat(actual, is(notNullValue()));
		assertThat(actual.getGroups().stream().findFirst().get().getGroupName(), is(equalTo
				("TestGroup")));
	}

	@Test
	public void oneToMany_validateOneToMany_returnUserWithMultipleGroup() {
		//inserted as part of the application start up - commandLineRunner @see OneToManyApplication
		User actual = userRepository.findByFirstNameAndLastName("Tom", "Jerry");
		assertThat(actual, is(notNullValue()));
		assertThat(actual.getGroups().size(), is(equalTo(2)));
	}

}
