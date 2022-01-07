package com.example.springboot.api;

import com.example.springboot.model.Person;
import com.example.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService _personService;

    @Autowired
    public PersonController(PersonService personService) {
        _personService = personService;
    }

    @PostMapping()
    public void addPerson(@RequestBody Person person){
        _personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAll(){
        return  _personService.getAllPerson();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return _personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        _personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void uptadatePerson(@PathVariable("id") UUID id, @RequestBody Person personToUpdate){
        _personService.updatePerson(id,personToUpdate);
    }
}
