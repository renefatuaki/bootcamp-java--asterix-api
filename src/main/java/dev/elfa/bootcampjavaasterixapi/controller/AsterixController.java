package dev.elfa.bootcampjavaasterixapi.controller;

import dev.elfa.bootcampjavaasterixapi.model.Character;
import dev.elfa.bootcampjavaasterixapi.DTO.CharacterDto;
import dev.elfa.bootcampjavaasterixapi.service.CharacterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asterix")
public class AsterixController {
    private final CharacterService characterService;

    public AsterixController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/characters")
    public List<Character> getCharacters(@RequestParam(required = false) String profession) {
        return characterService.getCharacters(profession);
    }

    @PostMapping("/character")
    public void addCharacter(@RequestBody CharacterDto character) {
        characterService.addCharacter(character);
    }

    @PutMapping("/character/{id}")
    public void updateCharacter(@PathVariable String id, @RequestBody CharacterDto character) {
        characterService.updateCharacter(id, character);
    }

    @DeleteMapping("/character/{id}")
    public void deleteCharacter(@PathVariable String id) {
        characterService.deleteCharacter(id);
    }
}
