package com.cdac.hss.enums;

public enum ExpertType {

    NEW_WORD_ENTRY(101),
    WORK_ON_ALLOTED(201),
    BOTH(301);

    private final int id;

    ExpertType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static ExpertType fromId(int id) {
        for (ExpertType type : values()) {
            if (type.id == id) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid ExpertTypeEnum id: " + id);
    }
}
