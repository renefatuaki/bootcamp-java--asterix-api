package dev.elfa.bootcampjavaasterixapi.DTO;

import dev.elfa.bootcampjavaasterixapi.model.Character;

public record CharacterDto(String name, int age, String profession) {

    public static CharacterDto transform(Character character) {
        return new CharacterDto(character.name(), character.age(), character.profession());
    }
}
