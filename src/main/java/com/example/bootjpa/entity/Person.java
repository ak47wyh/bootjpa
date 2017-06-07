package com.example.bootjpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Created by Administrator on 2017/6/7.
 */
@Entity
@NamedQuery(name = "Person.withNameAndAddressNameQuery",query = "select p from Person p where p.name =?1 and p.address =?2")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int age;

    private String address;

    public Person() {
        super();
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
