package com.rabtank.fishbot_function.service;

import com.rabtank.fishbot_function.entity.FishingLocation;
import com.rabtank.fishbot_function.repository.FishingLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FishService implements CommandService {
    @Autowired
    private FishingLocationRepository fishingLocationRepository;

    @Override
    public List<String> execute(List<String> args, String userUnionId) {
        List<String> backList = new ArrayList<>();

        if (args.isEmpty()) {
            // 调用 repository 层方法获取所有渔场信息
            List<FishingLocation> allLocations = fishingLocationRepository.findAll();
            if (allLocations != null) {
                for (FishingLocation location : allLocations) {
                    backList.add("text");
                    backList.add(location.toString()); // 你可以自定义 toString 方法来格式化输出
                }
            } else {
                backList.add("text");
                backList.add("未找到任何渔场信息");
            }
        } else {
            // 调用 repository 层方法获取指定渔场信息
            String locationName = args.get(0);
            FishingLocation location = fishingLocationRepository.findByName(locationName);
            if (location != null) {
                backList.add("text");
                backList.add(location.toString()); // 你可以自定义 toString 方法来格式化输出
            } else {
                backList.add("text");
                backList.add("未找到指定的渔场");
            }
        }

        return backList;
    }
}