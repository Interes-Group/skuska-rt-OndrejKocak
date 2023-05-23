package sk.stuba.fei.uim.oop.logic;

import lombok.Getter;

public enum Mode {
    SQUARE("Square"),
    CIRCLE("Circle"),
    HOURGLASS("Hourglass");

    @Getter
    private final String modeName;

    Mode(String modeName) {
        this.modeName = modeName;
    }
}
