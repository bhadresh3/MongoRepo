package com.system27.mongo.Service;

import com.system27.mongo.Model.Person;

import java.util.List;

public interface PersonService {

    Person add(Person person);

    List<Person> findAll();

    Person update(Person person);

    void delete(String id);

    List<Person> findAllByPage(int pageNo, int pageSize);

    List<Person> findAllByName(String name);

    List<Person> findBySalary(int salary);

    List<Person> findByZipCode(int zipCode);

    List<Person> findByCity(String city);

    List<Person> findByAge(int lAge, int hAge);
}
