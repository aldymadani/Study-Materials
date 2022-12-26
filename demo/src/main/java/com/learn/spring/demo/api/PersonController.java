package com.learn.spring.demo.api;

import com.learn.spring.demo.model.Person;
import com.learn.spring.demo.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

import static com.learn.spring.demo.constant.ControllerConstant.*;

@RequestMapping(V1 + PERSON)
@RestController
@AllArgsConstructor
public class PersonController {
    @Autowired
    private final PersonService personService;

    @PostMapping(ADD_PERSON)
    public void addPerson(@Validated @NotNull @RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping(GET_ALL_PERSON)
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping(path = ID)
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id);
    }

    @DeleteMapping(path = ID)
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }

    @PutMapping(path = ID)
    public void updatePerson(@PathVariable("id") UUID id, @Validated @NotNull @RequestBody Person personToUpdate) {
        personService.updatePerson(id, personToUpdate);
    }
}
