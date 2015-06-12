package com.ibapp.service;

import com.ibapp.domain.Person;
import com.ibapp.domain.Register;

import java.util.List;

/**
 * Created by imran on 14/04/15.
 */

public interface PersonService {

    public void insertPerson(Person person) throws Exception;

    public Person getPersonById(int id) throws Exception;

    public List<Person> getAllPersons() throws Exception;

    public void updatePerson(Person person) throws Exception;

    public void deletePerson(int id) throws Exception;
}
