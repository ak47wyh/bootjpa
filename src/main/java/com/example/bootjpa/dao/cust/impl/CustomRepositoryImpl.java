package com.example.bootjpa.dao.cust.impl;

import com.example.bootjpa.dao.cust.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

import static com.example.bootjpa.dao.cust.CustomerSpecs.byAuto;

/**
 * Created by Administrator on 2017/6/7.
 */
public class CustomRepositoryImpl <T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements CustomerRepository<T,ID> {

    private final EntityManager entityManager;

    public CustomRepositoryImpl(Class<T> doainClass, EntityManager entityManager) {
        super(doainClass, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Page<T> findByAuto(T example, Pageable pageable) {
        return findAll(byAuto(entityManager,example),pageable);
    }
}
