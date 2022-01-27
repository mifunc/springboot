package com.rumenz.lession5.controller.entity;

import javax.persistence.*;

/**
 * @className: Rumenz
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/11/4
 **/

@Entity
@Table(name = "rumenz")
public class Rumenz {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;


    public Rumenz(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Rumenz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
