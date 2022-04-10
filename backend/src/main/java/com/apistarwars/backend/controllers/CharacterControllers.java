package com.apistarwars.backend.controllers;
import com.apistarwars.backend.model.Character;
import com.apistarwars.backend.services.CharacterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/characters")
public class CharacterControllers {

    @Autowired
    private CharacterServices characterServices;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Character> findById(@PathVariable String id) {
        Character obj = characterServices.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<Character>> findAll() {
        List<Character> list = characterServices.findAll();
        return ResponseEntity.ok().body(list);
    }

}
