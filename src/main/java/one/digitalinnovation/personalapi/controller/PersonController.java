package one.digitalinnovation.personalapi.controller;

import one.digitalinnovation.personalapi.dto.MessageResponseDTO;
import one.digitalinnovation.personalapi.dto.request.PersonDTO;
import one.digitalinnovation.personalapi.entity.Person;
import one.digitalinnovation.personalapi.exception.PersonNotFoundException;
import one.digitalinnovation.personalapi.repository.PersonRepository;
import one.digitalinnovation.personalapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService= personService;
    }

    @PostMapping

    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
    return personService.createPerson(personDTO);

    }
    @GetMapping
    public List<PersonDTO> listAll() {
     return   personService.listAll();
}
    @GetMapping("/{id}")
    public PersonDTO findById (@PathVariable Long id) throws PersonNotFoundException {
            return  personService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
            personService.delete(id);
}
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updateById(id, personDTO);
    }

}
