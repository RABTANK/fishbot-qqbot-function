package com.rabtank.fishbot_function.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class MdTestService implements CommandService{

    @Override
    public List<String> execute(List<String> args, String userUnionId) {
        System.out.println(args);
        List<String> backList = new ArrayList<>();
        backList.add("markdown");
        backList.add("{\"custom_template_id\":\"\n" + "102074147_1740987502\",\"params\":[{\"key\":\"location1\",\"values\":[\"练习场\"]},{\"key\":\"location2\",\"values\":[\"练习场\"]},{\"key\":\"location3\",\"values\":[\"练习场\"]},{\"key\":\"location4\",\"values\":[\"练习场\"]}]}");
        backList.add("yes");
        backList.add("102074147_1740986528");
        return backList;
    }
    
}
