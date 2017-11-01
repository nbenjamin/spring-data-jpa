package com.nbenja.springdata.jpa.onetomanyrelation;

import com.nbenja.springdata.jpa.onetomanyrelation.domain.Group;
import com.nbenja.springdata.jpa.onetomanyrelation.domain.User;
import com.nbenja.springdata.jpa.onetomanyrelation.repository.GroupRepository;
import com.nbenja.springdata.jpa.onetomanyrelation.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;

@SpringBootApplication(scanBasePackages = "com.nbenja.springdata.jpa.onetomanyrelation")
public class OneToManyApplication {

    public static void main(String... args) {
        SpringApplication.run(OneToManyApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository, GroupRepository
            groupRepository) {
        System.out.println("TESTING  ");
        return (args) -> {

            User user = new User("Tom","Jerry","tomAndJerry","password");
            Group group1 = new Group("TestGroup-1", user);
            Group group2 = new Group("TestGroup-2", user);

            user.setGroups(new HashSet<Group>(){{
                add(group1);
                add(group2);
            }});

            userRepository.save(user);

        };
    }
}
