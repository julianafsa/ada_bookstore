package br.com.ada.bookstore.model.enumerations;

import java.util.stream.Stream;

public enum Category {
    ALBUM("Album"),
    BOOK("Book"),
    ADULT_AUDIENCE_BOOK("AdultAudienceBook"),
    GAME("Game"),
    MOVIE("Movie"),
    TOY("Toy");

    private String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Category fromName(final String name) {
        return Stream.of(Category.values())
                .filter((c) -> c.name.equals(name))
                .findFirst()
                .orElse(null);
    }

}
