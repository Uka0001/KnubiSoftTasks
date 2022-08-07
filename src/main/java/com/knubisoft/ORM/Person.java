package com.knubisoft.ORM;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {
    private String name;
    private int age;
    private float salary;
    private String position;
    private LocalDate dateOfBirth;

}
