package com.oran.springProject.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "groups")
public class GroupEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;
}
