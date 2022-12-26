package com.learn.spring.demo.service;

import com.learn.spring.demo.dao.PersonDao;
import com.learn.spring.demo.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PersonService {
    @Autowired
    private final PersonDao personDao;

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public Person getPersonById(UUID id) {
        return personDao.selectPersonById(id).orElse(null);
    }

    public int deletePerson(UUID id) {
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person person) {
        return personDao.updatePersonById(id, person);
    }
}
