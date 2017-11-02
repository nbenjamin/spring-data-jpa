package com.nbenja.springdata.jpa.manytomanyrelation.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "groups")
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
    private String groupName;

    @ManyToMany(mappedBy = "groups")
    //@ManyToMany
    //@JoinColumn(name = "userId", nullable = false)
    private Set<User> users;

    public Group(String groupName) {
        this.groupName = groupName;
    }
}