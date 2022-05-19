package com.oran.springProject.entity;

import com.oran.springProject.model.GenderType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @Column
    private boolean enabled;

    @ManyToOne(fetch = FetchType.EAGER)
    private GroupEntity group;
}
