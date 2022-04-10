package com.apistarwars.backend.model;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Document(collection = "apistarwars")
public class Character implements Serializable {

    @Id
    private String name;

    private String urlPhoto;

    private String planeta;

    private String raca;

    private  String historia;
}

