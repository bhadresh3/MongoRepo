package com.system27.mongo.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Document
public class Person {
    @Id
    @Generated
    private String id;
    private String name;
    private int salary;
    private int age;
    private Address address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
}
