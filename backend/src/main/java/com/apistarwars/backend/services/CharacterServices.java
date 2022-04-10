package com.apistarwars.backend.services;

import com.apistarwars.backend.model.Character;
import com.apistarwars.backend.repositories.CharacterRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServices {

    @Autowired
    private CharacterRepository repo;

    public Character findById(String id) {
        Optional<Character> obj = repo.findById(id);
        return obj.orElseThrow(() -> new RuntimeException());
    }

    public List<Character> findAll() {
        return repo.findAll();
    }
}
