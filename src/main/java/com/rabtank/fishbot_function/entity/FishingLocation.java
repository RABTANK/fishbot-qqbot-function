package com.rabtank.fishbot_function.entity;

import java.util.List;

public class FishingLocation {
    public int id;
    public String name;
    public int levelRestriction;
    public float hookDifficulty;
    public List<Fish> fishList;
    public String description;

    public FishingLocation(int id, String name, int levelRestriction, float hookDifficulty, List<Fish> fishList,
            String description) {
        this.id = id;
        this.name = name;
        this.levelRestriction = levelRestriction;
        this.hookDifficulty = hookDifficulty;
        this.fishList = fishList;
        this.description = description;
    }

    // 仅id构造方法
    public FishingLocation(int id) {
        this.id = id;
    }

    // 仅名字构造方法
    public FishingLocation(String name) {
        this.name = name;
    }
}