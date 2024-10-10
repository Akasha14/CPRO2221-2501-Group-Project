package com.example.gameProject.model;

public class AttackRequest {
    private String elementType;
    private String monsterType;
    private String monsterElementType;
    private int damageValue;

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    public String getMonsterElementType() {
        return monsterElementType;
    }

    public void setMonsterElementType(String monsterElementType) {
        this.monsterElementType = monsterElementType;
    }

    public int getDamageValue() {
        return damageValue;
    }

    public void setDamageValue(int damageValue) {
        this.damageValue = damageValue;
    }
}
