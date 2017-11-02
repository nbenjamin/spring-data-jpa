package com.nbenja.springdata.jpa.manytomanyrelation.repository;

import com.nbenja.springdata.jpa.manytomanyrelation.domain.Group;

import org.springframework.data.repository.CrudRepository;

/**
 *
 */
public interface GroupRepository extends CrudRepository<Group, Long> {

    Group findByGroupName(String groupName);
}
