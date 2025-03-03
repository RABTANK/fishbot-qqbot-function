package com.rabtank.fishbot_function.entity;

import java.util.List;

public class FishingLocation {
    private int id;
    private String name;
    private int levelRestriction;
    private float hookDifficulty;
    private String description;
    private List<Fish> fishList;

    public FishingLocation() {
    }

    public FishingLocation(int id, String name, int levelRestriction, float hookDifficulty, List<Fish> fishList,
            String description) {
        this.id = id;
        this.name = name;
        this.levelRestriction = levelRestriction;
        this.hookDifficulty = hookDifficulty;
        this.fishList = fishList;
        this.description = description;
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

    public int getLevelRestriction() {
        return levelRestriction;
    }

    public void setLevelRestriction(int levelRestriction) {
        this.levelRestriction = levelRestriction;
    }

    public float getHookDifficulty() {
        return hookDifficulty;
    }

    public void setHookDifficulty(float hookDifficulty) {
        this.hookDifficulty = hookDifficulty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Fish> getFishList() {
        return fishList;
    }

    public void setFishList(List<Fish> fishList) {
        this.fishList = fishList;
    }

    @Override
    public String toString() {
        StringBuilder fishDetails = new StringBuilder();
        if (fishList != null) {
            for (Fish fish : fishList) {
                fishDetails.append(fish.toString()).append(", ");
            }
            // Remove the trailing comma and space
            if (fishDetails.length() > 0) {
                fishDetails.setLength(fishDetails.length() - 2);
            }
        }
        return "FishingLocation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", levelRestriction=" + levelRestriction +
                ", hookDifficulty=" + hookDifficulty +
                ", description='" + description + '\'' +
                ", fishList=[" + fishDetails.toString() + "]" +
                '}';
    }
}