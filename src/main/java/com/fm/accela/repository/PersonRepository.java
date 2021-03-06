package com.fm.accela.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fm.accela.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByFirstName(String name);
}
