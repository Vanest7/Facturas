package com.example.demo.domain.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    private int id;
    private String Name;
    private String Nationality;
    private String biography_es;
    private String biography_en;
    private int birth_year;
    private int death_year;

}
