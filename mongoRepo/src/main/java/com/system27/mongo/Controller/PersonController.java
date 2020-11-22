package com.system27.mongo.Controller;

import com.system27.mongo.Model.Person;
import com.system27.mongo.Service.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController {

    private final PersonServiceImpl personService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Person> findAll(){
        return personService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Person addPerson(@RequestBody Person person){

        return personService.add(person);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public Person updatePerson(@RequestBody Person person){
        return personService.update(person);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePerson(@RequestParam("id") String id){
         personService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/page")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> pageOfPerson(
            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "2") int pageSize)
    {
        return  personService.findAllByPage(pageNo,pageSize);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/byName")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> findAllPerson(@RequestParam(value = "name", required = true) String name)
    {
        return personService.findAllByName(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/bySalary")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> findPersonBySalary(@RequestParam(value = "salary", required = true) int salary)
    {
        return personService.findBySalary(salary);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/byZipCode")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> findPersonByZipCode(@RequestParam(value = "zipCode", required = true) int zipCode)
    {
        return personService.findByZipCode(zipCode);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/byCity")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> findPersonByCity(@RequestParam(value = "city", required = true) String city)
    {
        return personService.findByCity(city);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/byAge")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> findPersonByAge(@RequestParam(value = "lowAge", required = true) int lAge,
                                        @RequestParam(value = "highAge", required = true)  int hAge)
    {
        return personService.findByAge(lAge, hAge);
    }

}
