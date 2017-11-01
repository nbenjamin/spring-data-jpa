package com.nbenja.springdata.jpa.manytomanyrelation.repository;

import com.nbenja.springdata.jpa.manytomanyrelation.domain.User;

import org.springframework.data.repository.CrudRepository;

/**
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
