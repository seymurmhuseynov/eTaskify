package com.eTaskify.enums;

public enum EnumUser {

    ADMIN(1),
    USER(2);

    private final int type;

    EnumUser(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

}
