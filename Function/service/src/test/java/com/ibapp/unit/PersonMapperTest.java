package com.ibapp.unit;

import com.ibapp.domain.Person;
import com.ibapp.persistence.PersonMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by imran on 15/04/15.
 */

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class PersonMapperTest {

    @Autowired
    PersonMapper personMapper;


    @Test
/*    public void testInsertPerson() throws Exception{

       personMapper.insertPerson(getPerson());

    }*/

/*
    public void testUpdatePerson() throws Exception{

       personMapper.updatePerson(getPerson());

    }
*/

/*    public void testDeletePerson() throws Exception{

       personMapper.deletePerson(1);

    }*/

/*    public void testGetPersonById() throws Exception{

        personMapper.getPersonById(1);

    }*/

/*    public void testGetAllRegisters() throws Exception{

        RegisterMapper.getAllRegister();

    }*/

    private Person getPerson() {

        Person person = new Person();

        person.setId(1);
        person.setFirstName("Test First Name");
        person.setLastName("Test Last Name");
        person.setEmail("Test@Hotmail.com");
        person.setPassword("Test Password");

        return person;
    }





}
