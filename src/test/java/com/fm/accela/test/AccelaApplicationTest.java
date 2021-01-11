package com.fm.accela.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fm.accela.exception.PersonNotFoundException;
import com.fm.accela.model.Person;
import com.fm.accela.service.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccelaApplicationTest {

    @Autowired
    private PersonService personService;
    
    @Test
    public void testAddPerson() {
        Person person1 = new Person(1, "Anakin", "Skywalker");

        personService.addPerson(person1);

        Person person2 = new Person(2, "Obi-Wan", "Kenobi");

        personService.addPerson(person2);

        Person testPerson = personService.findPersonByFirstName("Anakin");

        Assert.assertEquals(testPerson.getFirstName(), "Anakin");
        Assert.assertEquals(testPerson.getLastName(), "Skywalker");

        List<Person> personList = personService.getListOfPersons();

        Assert.assertEquals(personList.size(), 2);
    }

    @Test
    public void testEditPerson() throws PersonNotFoundException {

        personService.editPerson(1, new Person("F", "M"));

        Person testPerson = personService.findPersonByFirstName("F");

        Assert.assertEquals(testPerson.getFirstName(), "F");
        Assert.assertEquals(testPerson.getLastName(), "M");
    }

}
