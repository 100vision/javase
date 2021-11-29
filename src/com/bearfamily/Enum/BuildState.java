package com.bearfamily.Enum;

public enum BuildState {
    NOTSTARTED(0),
    INITIAILIZING(1),
    OPEN(2),
    CLOSING(3);

    private int value;
    private BuildState(int value) {
        this.value=value;
    }
}
