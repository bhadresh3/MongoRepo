package com.system27.mongo.Model;

import lombok.*;

@Data
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String streetName;
    private String city;
    private String state;
    private int zipCode;
}
