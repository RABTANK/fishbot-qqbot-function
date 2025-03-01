package com.rabtank.fishbot_function.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GoodbyeService implements CommandService {

    @Override
    public List<String> execute(List<String> args, String userUnionId) {
        System.out.println(args);
        List<String> backList = new ArrayList<>();
        backList.add("text");
        backList.add("byebye:" + userUnionId);
        return backList;
    }
}