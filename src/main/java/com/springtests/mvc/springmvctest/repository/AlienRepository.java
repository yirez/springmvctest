package com.springtests.mvc.springmvctest.repository;

import com.springtests.mvc.springmvctest.model.Alien;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface AlienRepository extends CrudRepository<Alien, Integer> {
    Alien findById(int id);

    @Transactional
    List<Alien> findAll();
 
    void deleteById(int id);
}
