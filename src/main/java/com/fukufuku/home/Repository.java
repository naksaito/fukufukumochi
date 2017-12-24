package com.fukufuku.home;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("messages")
public class Repository {
    @Autowired
    RepositoryInterface repositoryInterface;

    @RequestMapping(method = RequestMethod.GET)
    public String getMessages() {
        List<String> getList = new ArrayList<>();
        for (Entity entity : repositoryInterface.findAll()){
            getList.add(entity.getId().toString() + ":" + entity.getText());
        }
        return getList.toString();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Entity postMessages(@RequestBody Entity message) {
        //Entity entity = new Entity(message);
        System.out.println(message);
        return repositoryInterface.save(message);
    }
}
