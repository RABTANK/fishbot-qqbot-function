package com.rabtank.fishbot_function.service;

import java.util.List;

public interface CommandService {
    String execute(List<String> args,String userUnionId);
}
