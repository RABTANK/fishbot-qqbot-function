package com.rabtank.fishbot_function.entity;

public class Fish {
    private int id;
    private String name;
    private float value;
    private float catchDifficulty;
    private String description;
    private float referenceWeight;
    private Float actualWeight;

    public Fish() {
    }

    public Fish(int id, String name, float value, float catchDifficulty, String description, float referenceWeight,
            Float actualWeight) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.catchDifficulty = catchDifficulty;
        this.description = description;
        this.referenceWeight = referenceWeight;
        this.actualWeight = actualWeight;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getCatchDifficulty() {
        return catchDifficulty;
    }

    public void setCatchDifficulty(float catchDifficulty) {
        this.catchDifficulty = catchDifficulty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getReferenceWeight() {
        return referenceWeight;
    }

    public void setReferenceWeight(float referenceWeight) {
        this.referenceWeight = referenceWeight;
    }

    public Float getActualWeight() {
        return actualWeight;
    }

    public void setActualWeight(Float actualWeight) {
        this.actualWeight = actualWeight;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", catchDifficulty=" + catchDifficulty +
                ", description='" + description + '\'' +
                ", referenceWeight=" + referenceWeight +
                ", actualWeight=" + actualWeight +
                '}';
    }
}