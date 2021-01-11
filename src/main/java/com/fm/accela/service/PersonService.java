package com.fm.accela.service;

import java.util.List;

import com.fm.accela.exception.PersonNotFoundException;
import com.fm.accela.model.Person;

public interface PersonService {

    void addPerson(Person newPerson);
    void editPerson(long personId, Person personDetails) throws PersonNotFoundException;
    void deletePerson(long personId) throws PersonNotFoundException;
    long getTotalNumberOfPersons();
    List<Person> getListOfPersons();
    	//for test purpose
    Person findPersonByFirstName(String firstName);
}