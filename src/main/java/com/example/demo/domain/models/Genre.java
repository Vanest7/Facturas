package com.example.demo.domain.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Genre {

    private int id;
    private String name_es;
    private String name_en;
    private String slug;
}
