package com.apistarwars.backend.model;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "characters")
public class Character implements Serializable {

    @Id
    private String name;

    private String urlPhoto;

    private String planeta;

    private String raca;

    private String nave;

    @Column(columnDefinition = "TEXT")
    private  String historia;
}

