package com.springtests.mvc.springmvctest.repository;

import com.springtests.mvc.springmvctest.model.Alien;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface AlienRepository extends CrudRepository<Alien, Integer> {
    Alien findById(int id);

    @Transactional
    List<Alien> findAll();

    //Query DSL, JPA will provide queries
    //Rules:
    // It must start with findBy...
    //Next letter must be capital
    // you can also add OrderByNameDesc and such as well
    List<Alien> findByName(String name);

    //custom queries with query annotation
    //Param annotation to match db column name with parameter
    @Query ("from Alien where id > :id")
    List<Alien> filterAliensWithBiggerID(@Param("id") int id);

    List<Alien> findByNameIgnoreCaseContaining(String name);
}
