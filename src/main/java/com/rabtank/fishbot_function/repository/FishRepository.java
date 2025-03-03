package com.rabtank.fishbot_function.repository;

import com.rabtank.fishbot_function.entity.Fish;
import java.util.List;

public interface FishRepository {
    Fish findById(int id);
    List<Fish> findAll();
}