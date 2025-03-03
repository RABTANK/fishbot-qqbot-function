package com.rabtank.fishbot_function.controller;

import com.rabtank.fishbot_function.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@RestController
public class CommandController {

    private final Map<String, CommandService> commandServiceMap = new HashMap<>();

    @Autowired
    public CommandController(ApplicationContext context) {
        try {
            Resource resource = new ClassPathResource("commands.properties");
            Properties properties = new Properties();
            try (InputStreamReader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
                properties.load(reader);
            }

            for (String commandName : properties.stringPropertyNames()) {
                String serviceClassName = properties.getProperty(commandName);
                try {
                    Class<?> serviceClass = Class.forName(serviceClassName);
                    CommandService service = (CommandService) context.getBean(serviceClass);
                    commandServiceMap.put(commandName.replace("commands.", ""), service);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/command")
    public List<String> executeCommand(@RequestParam List<String> command, @RequestParam String userUnionId) {
        if (command.isEmpty()) {
            return List.of("noreply","No command provided");
        }
    
        String commandName = command.get(0);
        List<String> args = command.subList(1, command.size());
    
        CommandService service = commandServiceMap.get(commandName);
        if (service == null) {
            return List.of("noreply","Unknown command: " + commandName);
        }
    
        return service.execute(args, userUnionId);
    }
}