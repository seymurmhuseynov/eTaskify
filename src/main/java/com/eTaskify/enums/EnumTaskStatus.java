package com.eTaskify.enums;

public enum EnumTaskStatus {

    OPEN(1),
    CLOSED(2);

    private final int type;

    EnumTaskStatus(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

}
