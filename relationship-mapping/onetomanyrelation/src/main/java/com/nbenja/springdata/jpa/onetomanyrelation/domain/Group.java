package com.nbenja.springdata.jpa.onetomanyrelation.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupId;
    private String groupName;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Group(String groupName, User user) {
        this.groupName = groupName;
        this.user = user;
    }
}

//uniqueConstraints = {@UniqueConstraint(columnNames = {"userId", "groupName"})}