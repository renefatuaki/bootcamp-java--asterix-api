package dev.elfa.bootcampjavaasterixapi.repository;

import dev.elfa.bootcampjavaasterixapi.model.Character;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsterixRepository extends MongoRepository<Character, String> {
    List<Character> findCharactersByProfession(String profession);
}
