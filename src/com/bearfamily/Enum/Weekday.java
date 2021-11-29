package com.bearfamily.Enum;

public enum Weekday {
    SUN(0),
    MON(1),
    TUE(2),
    WED(3),
    THU(4),
    FRI(5),
    SAT(6);

    private int value;
    private Weekday(int value) {
        this.value=value;
    }
}
