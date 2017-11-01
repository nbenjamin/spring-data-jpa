package com.nbenja.springdata.jpa.onetomanyrelation.repository;

import com.nbenja.springdata.jpa.onetomanyrelation.domain.User;

import org.springframework.data.repository.CrudRepository;

/**
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByFirstNameAndLastName(String firstName, String lastName);
}
