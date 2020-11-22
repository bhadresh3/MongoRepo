package com.system27.mongo.Repo;

import com.system27.mongo.Model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends MongoRepository<Person, String> {

    List<Person> findBySalary(int salary);
    List<Person> findByAddressZipCode(int salary);

    @Query("{ 'address.city' : { $regex: ?0 }}")
    List<Person> findByCityJpql(String city);

    @Query(value = "{ 'age' : { $gt: ?0, $lt: ?1 } }", fields = "{'name':1,'age':1,'id':0}")
    List<Person> findPersonByAgeBetween(int ageGT, int ageLT);

}
