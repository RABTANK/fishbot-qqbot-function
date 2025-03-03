package com.rabtank.fishbot_function.repository;

import com.rabtank.fishbot_function.entity.FishingLocation;
import java.util.List;

public interface FishingLocationRepository {
    FishingLocation findByName(String name);
    List<FishingLocation> findAll();
}