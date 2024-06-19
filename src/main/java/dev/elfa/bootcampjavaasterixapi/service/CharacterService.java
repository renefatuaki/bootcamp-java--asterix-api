package dev.elfa.bootcampjavaasterixapi.service;

import dev.elfa.bootcampjavaasterixapi.DTO.CharacterDto;
import dev.elfa.bootcampjavaasterixapi.model.Character;
import dev.elfa.bootcampjavaasterixapi.repository.AsterixRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    private final AsterixRepository asterixRepository;
    private final IdService idService;

    public CharacterService(AsterixRepository asterixRepository, IdService idService) {
        this.asterixRepository = asterixRepository;
        this.idService = idService;
    }

    public List<Character> getCharacters() {
        return this.asterixRepository.findAll();
    }

    public List<Character> getCharacters(String profession) {
        return this.asterixRepository.findCharactersByProfession(profession);
    }

    public Optional<Character> getCharacter(String id) {
        return this.asterixRepository.findById(id);
    }

    public void addCharacter(CharacterDto characterDto) {
        Character character = new Character(idService.generateUUID(), characterDto.name(), characterDto.age(), characterDto.profession());
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
