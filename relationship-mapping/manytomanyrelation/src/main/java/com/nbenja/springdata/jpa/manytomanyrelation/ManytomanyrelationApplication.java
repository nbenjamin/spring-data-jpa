package com.nbenja.springdata.jpa.manytomanyrelation;

import static java.util.Arrays.asList;

import com.nbenja.springdata.jpa.manytomanyrelation.domain.Group;
import com.nbenja.springdata.jpa.manytomanyrelation.domain.User;
import com.nbenja.springdata.jpa.manytomanyrelation.repository.GroupRepository;
import com.nbenja.springdata.jpa.manytomanyrelation.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.HashSet;

@SpringBootApplication
public class ManytomanyrelationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManytomanyrelationApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserRepository userRepository, GroupRepository
			groupRepository) {
		return (args) -> {
			User user1 = new User("Ryan","Benjamin","ryanB","password");
			User user2 = new User("Adam","Benjamin","adamB","password");
			User user3 = new User("Chris","Benjamin","chrisB","password");
			User user4 = new User("Anzil","Antony","anzilA","password");

			Group group1 = new Group("TestGroup");

			Group group2 = new Group("DemoGroup");

			user1.setGroups(new HashSet<Group>(){{
				add(group1);
				add(group2);
			}});

			user3.setGroups(new HashSet<Group>(){{
				add(group1);
				add(group2);
			}});

			userRepository.save(asList(user1, user2, user3, user4));

			User user4Found = userRepository.findByFirstNameAndLastName("Anzil", "Antony");
			Group groupFound = groupRepository.findByGroupName("TestGroup");
			user4Found.setGroups(Collections.singleton(groupFound));

			userRepository.save(user4Found);
		};
	}
}
