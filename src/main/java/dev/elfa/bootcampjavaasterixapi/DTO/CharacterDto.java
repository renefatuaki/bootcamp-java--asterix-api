package dev.elfa.bootcampjavaasterixapi.DTO;

import dev.elfa.bootcampjavaasterixapi.model.Character;
import lombok.Getter;

import java.util.Optional;

@Getter
public record CharacterDto(String name, int age, String profession) {

    public static CharacterDto transform(Optional<Character> character) {
        return new CharacterDto(character.get().name(), character.get().age(), character.get().profession());
    }
}
