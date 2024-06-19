package dev.elfa.bootcampjavaasterixapi.service;

import dev.elfa.bootcampjavaasterixapi.repository.AsterixRepository;
import org.junit.jupiter.api.Test;

import dev.elfa.bootcampjavaasterixapi.model.Character;
import dev.elfa.bootcampjavaasterixapi.DTO.CharacterDto;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CharacterServiceTest {
    private final AsterixRepository mockAsterixRepo = mock(AsterixRepository.class);
    private final IdService idService = mock(IdService.class);


    @Test
    void getCharacters() {
        // Mocking data
        Character expectedCharacter1 = new Character("1", "Asterix", 30, "Soldier");
        Character expectedCharacter2 = new Character("2", "Felix", 30, "Soldier");
        List<Character> characterList = List.of(expectedCharacter1, expectedCharacter2);
        when(mockAsterixRepo.findAll()).thenReturn(characterList);

        // Service
        CharacterService characterService = new CharacterService(mockAsterixRepo, idService);

        // Run test
        List<Character> result = characterService.getCharacters();

        // Check if method got called
        verify(mockAsterixRepo).findAll();

        // Check expected result
        assertEquals(characterList, result);
    }

    @Test
    void findCharacterById() {
        // Mocking data
        Character expectedCharacter = new Character("1", "Asterix", 30, "Soldier");
        when(mockAsterixRepo.findById("1")).thenReturn(Optional.of(expectedCharacter));

        // Service
        CharacterService characterService = new CharacterService(mockAsterixRepo, idService);

        // Run test
        Optional<Character> result = characterService.getCharacter("1");

        // Check if method got called
        verify(mockAsterixRepo).findById("1");

        // Check expected result
        assertEquals(Optional.of(expectedCharacter), result);
    }

    @Test
    void updateCharacter() {
        // Mocking data
        CharacterDto characterDto = new CharacterDto("Asterix", 30, "Soldier");
        Character expectedCharacter = new Character("1", "Asterix", 30, "Soldier");
        when(mockAsterixRepo.save(any(Character.class))).thenReturn(expectedCharacter);

        // Service
        CharacterService characterService = new CharacterService(mockAsterixRepo, idService);

        // Run test
        characterService.updateCharacter("1", characterDto);

        // Check if method got called
        verify(mockAsterixRepo).save(any(Character.class));
    }

    @Test
    void deleteCharacter() {
        // Mocking data
        Character expectedCharacter = new Character("1", "Asterix", 30, "Soldier");
        when(mockAsterixRepo.save(any(Character.class))).thenReturn(expectedCharacter);

        // Service
        CharacterService characterService = new CharacterService(mockAsterixRepo, idService);

        // Run test
        characterService.deleteCharacter("1");

        // Check if method got called
        verify(mockAsterixRepo).deleteById("1");
    }
}