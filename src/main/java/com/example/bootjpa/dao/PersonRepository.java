package com.example.bootjpa.dao;

import com.example.bootjpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */
public interface PersonRepository extends JpaRepository<Person,Long> {
//根据方法名查询
    List<Person> findAllByAddress(String name);

    Person findAllByNameAndAddress(String name,String address);
//通过注解写sql查询 @query
    @Query("select p from Person p where p.name =:name and p.address =:address")
    Person withNameAndAddressQuery(String name,String address);
//通过引用实体里面定义的@NameQuery查询，
    Person withNameAndAddressNameQuery(String name,String address);
}
