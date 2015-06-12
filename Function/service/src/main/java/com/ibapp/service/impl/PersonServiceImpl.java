package com.ibapp.service.impl;

import com.ibapp.domain.Person;
import com.ibapp.domain.Register;
import com.ibapp.persistence.PersonMapper;
import com.ibapp.persistence.RegisterMapper;
import com.ibapp.service.PersonService;
import com.ibapp.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by imran on 14/04/15.
 */
@Component
@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonMapper personMapper;

    @Override
    public void insertPerson(Person person) throws Exception {

        personMapper.insertPerson(person);

    }

    @Override
    public Person getPersonById(int id) throws Exception {

        return personMapper.getPersonById(id);
    }

    @Override
    public List<Person> getAllPersons() throws Exception {

        return personMapper.getAllPersons();
    }

    @Override
    public void updatePerson(Person person) throws Exception {

        personMapper.updatePerson(person);

    }

    @Override
    public void deletePerson(int id) throws Exception {

        personMapper.deletePerson(id);

    }
}
