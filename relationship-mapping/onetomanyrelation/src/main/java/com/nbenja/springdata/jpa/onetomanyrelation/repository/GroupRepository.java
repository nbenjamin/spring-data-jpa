package com.nbenja.springdata.jpa.onetomanyrelation.repository;

import com.nbenja.springdata.jpa.onetomanyrelation.domain.Group;

import org.springframework.data.repository.CrudRepository;

/**
 *
 */
public interface GroupRepository extends CrudRepository<Group, Long> {
}
