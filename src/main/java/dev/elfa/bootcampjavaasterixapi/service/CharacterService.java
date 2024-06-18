package dev.elfa.bootcampjavaasterixapi.service;

import dev.elfa.bootcampjavaasterixapi.model.Character;
import dev.elfa.bootcampjavaasterixapi.DTO.CharacterDto;
import dev.elfa.bootcampjavaasterixapi.repository.AsterixRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    private final AsterixRepository asterixRepository;
    private final UUIDGenerator uuidGenerator;

    public CharacterService(AsterixRepository asterixRepository, UUIDGenerator uuidGenerator) {
        this.asterixRepository = asterixRepository;
        this.uuidGenerator = uuidGenerator;
    }

    public List<Character> getCharacters(String profession) {
        if (profession != null && !profession.isEmpty()) {
            return this.asterixRepository.findCharactersByProfession(profession);
        } else {
            return this.asterixRepository.findAll();
        }
    }

    public void addCharacter(CharacterDto characterDto) {
        Character character = new Character(uuidGenerator.generateUUID(), characterDto.name(), characterDto.age(), characterDto.profession());
        this.asterixRepository.save(character);
    }

    public void updateCharacter(String id, CharacterDto characterDto) {
        Character character = new Character(id, characterDto.name(), characterDto.age(), characterDto.profession());
        this.asterixRepository.save(character);
    }

    public void deleteCharacter(String id) {
        this.asterixRepository.deleteById(id);
    }
}
