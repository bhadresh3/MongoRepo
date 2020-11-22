package com.system27.mongo.Service;

import com.system27.mongo.Model.Person;
import com.system27.mongo.Repo.PersonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{
    private final PersonRepo personRepo;

    public Person add(Person person) {
        return personRepo.save(person);
    }

    public List<Person> findAll() {
        return personRepo.findAll();
    }

    public Person update(Person person) {
         return personRepo.save(person);
    }

    public void delete(String id) {
        Optional<Person> p = personRepo.findById(id);
        p.ifPresent(personRepo::delete);
    }

    public List<Person> findAllByPage(int pageNo, int pageSize) {
        Page<Person> people = personRepo.findAll(
                PageRequest.of(pageNo,pageSize,Sort.by(Sort.Direction.ASC, "name")));
        if(people.hasContent())
            return people.toList();
        else
            return new ArrayList<>();
    }

    public List<Person> findAllByName(String name){
        Person p = new Person();
        p.setName(name);
        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withIgnoreCase()
                .withMatcher("name",
                        ExampleMatcher.GenericPropertyMatcher
                                .of(ExampleMatcher.StringMatcher.CONTAINING));
        Example<Person> personExample = Example.of(p, matcher);
        return personRepo.findAll(personExample);
    };

    public List<Person> findBySalary(int salary){
        return personRepo.findBySalary(salary);
    };

    public List<Person> findByZipCode(int zipCode){
        return personRepo.findByAddressZipCode(zipCode);
    };

    public List<Person> findByCity(String city) {
        return personRepo.findByCityJpql(city);
    }

    public List<Person> findByAge(int lAge, int hAge){
        return personRepo.findPersonByAgeBetween(lAge, hAge);
    };
}
