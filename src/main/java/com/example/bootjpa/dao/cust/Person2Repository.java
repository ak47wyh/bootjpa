package com.example.bootjpa.dao.cust;

import com.example.bootjpa.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */
public interface Person2Repository extends CustomerRepository<Person,Long> {

    List<Person> findByAddress(String address);
    Person findByNameAndAddress(String name,String address);
    @Query("select p from Person p where p.name= :name and p.address= :address")
    Person withNameAndAddressQuery(@Param("name")String name,@Param("address")String address);
    Person withNameAndAddressNameQuery(String name,String address);
}
