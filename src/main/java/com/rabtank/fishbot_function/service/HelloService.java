package com.rabtank.fishbot_function.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class HelloService implements CommandService {

    @Override
    public List<String> execute(List<String> args, String userUnionId) {
        System.out.println(args);
        List<String> backList = new ArrayList<>();
        backList.add("text");
        backList.add("hello!" + userUnionId);
        backList.add("yes");
        backList.add("102074147_1740986528");
        return backList;
    }
}