package com.rabtank.fishbot_function.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public class FishService implements CommandService{

    @Override
    public List<String> execute(List<String> args, String userUnionId) {
        List<String> backList=new ArrayList<String>();
        backList.add("text");
        backList.add("开发中");
        return backList;
    }
    
}
