package com.example.springboot.service;

import com.example.springboot.dao.PersonDao;
import com.example.springboot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private  final PersonDao _personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        _personDao = personDao;
    }

    public int addPerson(Person person){
        return _personDao.addPerson(person);
    }

    public List<Person> getAllPerson(){
        return _personDao.selectAllPerson();
    }
    public Optional<Person> getPersonById(UUID id){
        return _personDao.selectPersonById(id);
    }
    public int deletePerson(UUID id){
        return _personDao.deletePersonById(id);
    }
    public  int updatePerson(UUID id,Person person){
        return _personDao.updatePersonById(id,person);
    }
}
