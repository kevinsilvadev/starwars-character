package com.apistarwars.backend.repositories;

import com.apistarwars.backend.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CharacterRepository extends MongoRepository<Character, String> {
}
