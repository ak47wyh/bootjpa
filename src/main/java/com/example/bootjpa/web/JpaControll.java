package com.example.bootjpa.web;

import com.example.bootjpa.dao.PersonRepository;
import com.example.bootjpa.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */
@RestController
public class JpaControll {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/save")
    public Person save(String name, String address , Integer age){
        Person person = personRepository.save(new Person(name,age,address));
        return person;
    }

    @RequestMapping("/findByAddress")
    public List<Person> findByAddress(String address){
        List<Person> people = personRepository.findAllByAddress(address);
        return people;
    }

    @RequestMapping("/findByNameAndAddress")
    public Person findByNameAndAddress(String name,String address){
        Person person = personRepository.findAllByNameAndAddress(name,address);
        return person;
    }

    @RequestMapping("/query")
    public Person query(String name , String address){
        Person person = personRepository.withNameAndAddressQuery(name,address);
        return person;
    }

    @RequestMapping("/nameQuery")
    public Person nameQuery(String name,String address){
        Person person = personRepository.withNameAndAddressNameQuery(name,address);
        return person;
    }

    @RequestMapping("/sort")
    public List<Person> sort(){
        List<Person> people = personRepository.findAll(new Sort(Sort.Direction.ASC,"name"));
        return people;
    }

    @RequestMapping("/page")
    public Page<Person> page(){
        Page<Person> people = personRepository.findAll(new PageRequest(1,2));
        return people;
    }
}
