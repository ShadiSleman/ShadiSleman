package com.NBA.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Player {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nickName")
    private String nickName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "position")
    private String position;

}

