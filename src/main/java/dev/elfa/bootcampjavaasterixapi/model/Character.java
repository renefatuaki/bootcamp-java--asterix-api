package dev.elfa.bootcampjavaasterixapi.model;

import org.springframework.data.annotation.Id;

public record Character(@Id String id, String name, int age, String profession) {
}
